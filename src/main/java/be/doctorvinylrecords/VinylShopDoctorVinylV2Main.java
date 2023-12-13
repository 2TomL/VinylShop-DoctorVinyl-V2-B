package be.doctorvinylrecords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan
public class VinylShopDoctorVinylV2Main {

    public static void main(String[] args) {
        SpringApplication.run(VinylShopDoctorVinylV2Main.class, args);
    }
}
