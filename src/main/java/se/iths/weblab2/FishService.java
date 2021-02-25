package se.iths.weblab2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FishService {

    private FishRepository fishRepository;

    public FishService(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    public List<FishDto> getAllFish(){
        return mapp(fishRepository.findAll());
    }

    public Optional<FishDto> getOne(Integer id){
        return mapp(fishRepository.findById(id));
    }

    public FishDto createFish(FishDto fish){
        if (fish.getName().isEmpty())
            throw new RuntimeException();
        return mapp(fishRepository.save(mapp(fish)));
    }

    public FishDto mapp(Fish fish){
        return new FishDto(fish.getId(), fish.getName(), fish.getType(), fish.getGender());
    }

    public Fish mapp(FishDto fishDto){
        return new Fish(fishDto.getId(), fishDto.getName(), fishDto.getType(), fishDto.getGender());
    }

    public Optional<FishDto> mapp(Optional<Fish> optionalFish){
        if (optionalFish.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalFish.get()));
    }

    public List<FishDto> mapp(List<Fish> all){
        List<FishDto> fishDtoList = new ArrayList<>();
        for (var fish : all){
            fishDtoList.add(mapp(fish));
        }
        return fishDtoList;
    }

}
