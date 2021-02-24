package se.iths.weblab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private FishRepository fishRepository;

    @Autowired
    public Controller(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    @GetMapping("/hello")
    public String sayHello(){

        return "Hello World";
    }
}