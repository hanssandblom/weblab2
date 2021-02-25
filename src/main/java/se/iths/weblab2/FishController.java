package se.iths.weblab2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
public class FishController {

    private FishService fishService;

    public FishController(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping("/fish")
    public List<FishDto> all(){
        return fishService.getAllFish();
    }

    @GetMapping("/fish/{id}")
    public FishDto one(@PathVariable Integer id){
        return fishService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find id " + id));
    }

    @PostMapping("/fish")
    @ResponseStatus(HttpStatus.CREATED)
    public FishDto create(@RequestBody FishDto fish){
        return fishService.createFish(fish);
    }

}