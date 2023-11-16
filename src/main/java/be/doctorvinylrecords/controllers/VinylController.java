package be.doctorvinylrecords.controllers;

import be.doctorvinylrecords.model.Vinyl;
import be.doctorvinylrecords.service.VinylService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class VinylController {
    private final VinylService vinylService;
    @Autowired
    public VinylController(VinylService vinylService) {
        this.vinylService = vinylService;
    }
    @PostMapping("add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addVinyl(@RequestBody Vinyl vinyl){
        return vinylService.addVinyl(vinyl);
    }
    @GetMapping("getVinyls")
    public List<Vinyl> getAllVinyls() {
        return vinylService.getAllVinyls();
    }
}
