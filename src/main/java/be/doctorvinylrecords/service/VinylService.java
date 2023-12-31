package be.doctorvinylrecords.service;

import be.doctorvinylrecords.model.Status;
import be.doctorvinylrecords.model.Vinyl;
import be.doctorvinylrecords.payload.response.MessageResponse;
import be.doctorvinylrecords.repository.VinylRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class VinylService {
    private VinylRepository vinylRepository;

    public VinylService(VinylRepository vinylRepository) {
        this.vinylRepository = vinylRepository;
    }

    public Optional<Vinyl> findByID(long vinylId) {
        return vinylRepository.findById(vinylId);
    }

    @Transactional
    public ResponseEntity<?> deleteVinylById(long vinylId) {
        Optional<Vinyl> vinylCheck = vinylRepository.findById(vinylId).stream().findFirst();
        if (vinylCheck.isEmpty()){
            return ResponseEntity.badRequest().body(new MessageResponse("Vinyl does not exists or can not be found"));
        }
        if (isOutOfStockOrPending(vinylCheck.get())){
            return ResponseEntity.badRequest().body(new MessageResponse("Vinyl is out of stock or pending"));
        }
        vinylRepository.deleteById(vinylId);
        return ResponseEntity.ok().build();
    }
    public Optional<Vinyl> getVinylById(long vinylId){
        return vinylRepository.findById(vinylId);
    }
    public ResponseEntity<?> addVinyl (Vinyl vinyl){
        if (vinyl==null){
            return ResponseEntity.badRequest().body(new MessageResponse("Vinyl does not exists or can not be found"));
        }
        return ResponseEntity.ok(vinylRepository.save(vinyl));
    }
    private boolean isOutOfStockOrPending(Vinyl vinyl){
        return (vinyl.getStatus().equals(Status.OUT_OF_STOCK)) || vinyl.getStatus().equals(Status.PENDING);
    }
    public List<Vinyl> getAllVinyls(){
        return vinylRepository.findAll();
    }
    public List<Vinyl> searchVinyl(String query){
        return vinylRepository.searchVinyl(query);
    }

    public boolean addImage(String imagePath, String fileName, MultipartFile multipartFile) {

        Path path = Paths.get(imagePath);
        if (!path.toFile().exists()) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            try (InputStream inputStream = multipartFile.getInputStream()) {
                Path filePath = path.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

                return true;
            } catch (IOException e) {
                return false;
            }
        }

}
