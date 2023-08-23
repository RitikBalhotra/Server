package com.Rb.Controller;

import com.Rb.Dto.CarDto;
import com.Rb.Repository.CarRepository;
import com.Rb.Service.CarService;
import com.Rb.model.Car;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/c1")
public class CarController {

    private final CarService carService;
    private final CarRepository carRepository;
    private String path = "images/";

    private static final String imageDirectory = System.getProperty("user.dir") + "/images/";

    @PostMapping(
            path = "/add/car",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> insertCar(@RequestParam("image") MultipartFile image,
                                       @RequestParam("name") String name,
                                       @RequestParam("model") String model,
                                       @RequestParam("colour") String colour,
                                       @RequestParam("price") Double price
    ) throws IOException {
        System.out.println(image.getOriginalFilename() + name + model + colour + price);


        var car = Car.builder()
                .name(name)
                .model(model)
                .colour(colour)
                .price(price)
                .imageName(image.getOriginalFilename())
                .build();
        makeDirectoryIfNotExist(imageDirectory);
        Path fileNamePath = Paths.get(imageDirectory,
                image.getOriginalFilename());
        System.out.println(fileNamePath);
        Car car1 = carService.insertCar((car));
        try {
            Files.write(fileNamePath, image.getBytes());
            return new ResponseEntity<>(name + "image Upload Successfully", HttpStatus.CREATED);
        } catch (IOException ex) {
            return new ResponseEntity<>("Image is not uploaded", HttpStatus.BAD_REQUEST);
        }
    }

    //method to serve files
    @GetMapping(value = "/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            @PathVariable("imageName") String imageName,
            HttpServletResponse response
    ) throws IOException {


        InputStream resource = getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());

    }

    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        InputStream is = new FileInputStream(fullPath);
        System.out.println(fullPath);
        System.out.println(is);
        // db logic to return inpustream
        return is;
    }

    private void makeDirectoryIfNotExist(String imageDirectory) {
        File directory = new File(imageDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }

    }

//    @GetMapping("/")
//    public ResponseEntity<?> getData() {
//        return ResponseEntity.ok("Hello From Backend!");
//    }

    @GetMapping("/get/car/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }


    @GetMapping("/get/All/Cars")
    public ResponseEntity<?> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/Car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") int id) {
        carService.deleteCar(id);
        return ResponseEntity.ok(HttpStatus.OK + "Data delete Successfully");
    }

    @PutMapping("/update/car")
    public ResponseEntity<?> updateCar(@RequestBody Car car) {

        return new ResponseEntity<>(carService.UpdateCar(car), HttpStatus.OK);
    }


//    public  int idGenerator(String name) {
//
//        if (name.equals("Car")) {
//                int GT_ID=getId();
//                int DB_ID = carRepository.getById(GT_ID).getId();
//            if (DB_ID==GT_ID) {
//                GT_ID= getId();
//
//            }
//            return GT_ID;
//        } else if (name.equals("User")) {
//            return 0;
//        } else {
//            return 0;
//        }
//
//
//    }
//
//    public  int getId(){
//
//        double id=1868617;
//        for (int i=1;i<=20;i++){
//            double d=Math.random();
//            id+=d;
//        }
//        System.out.println(Integer.valueOf((int) id));
//
//
//        return 0;
//    }

}
