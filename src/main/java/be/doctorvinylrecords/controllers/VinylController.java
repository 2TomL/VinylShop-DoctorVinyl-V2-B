package be.doctorvinylrecords.controllers;

import be.doctorvinylrecords.model.Status;
import be.doctorvinylrecords.model.Vinyl;
import be.doctorvinylrecords.service.VinylService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vinyl")
public class VinylController {
    private final VinylService vinylService;
    @Autowired
    public VinylController(VinylService vinylService) {
        this.vinylService = vinylService;
    }

    @PostMapping("add")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addVinyl(@RequestBody Vinyl vinyl){
        return vinylService.addVinyl(vinyl);
    }
    @GetMapping("getVinyls")
    public List<Vinyl> getAllVinyls() {
        return vinylService.getAllVinyls();
    }
    @GetMapping("getvinyl")
    public Optional<Vinyl> getAllVinyls(long id){return vinylService.getVinylById(id);}
    @GetMapping("search")
    public List<Vinyl> searchVinyls (String query){
        return vinylService.searchVinyl(query);
    }
    @DeleteMapping("delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteVinyl(Long vinylId){
        return vinylService.deleteVinylById(vinylId);
    }

    @PostMapping("/addimage")
    public ResponseEntity<String> daveImage(@RequestParam(value = "file") MultipartFile multipartFile ){
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String imagePath = "src/main/resources/coverImages/";
        boolean success = vinylService.addImage(imagePath,fileName,multipartFile);
        if (success) {
            return ResponseEntity.ok(imagePath+fileName);

        }
        return ResponseEntity.badRequest().build();
    }
//    @PostMapping("status")
//    @PreAuthorize("hasRole('ADMIN')")
//    public void changeStatus(long id, Status status){
//        vinylService.changeStatus(id, status);
//    }
//    @PutMapping("update")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> updateVinyl(@RequestBody Vinyl vinyl){
//        return (vinylService.updateVinyl(vinyl));
//    }

}
