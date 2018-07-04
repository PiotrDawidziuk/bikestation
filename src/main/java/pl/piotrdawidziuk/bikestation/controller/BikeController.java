package pl.piotrdawidziuk.bikestation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.piotrdawidziuk.bikestation.model.Bike;
import pl.piotrdawidziuk.bikestation.model.Slot;
import pl.piotrdawidziuk.bikestation.model.Station;
import pl.piotrdawidziuk.bikestation.repository.BikeRepository;
import pl.piotrdawidziuk.bikestation.repository.SlotRepository;
import pl.piotrdawidziuk.bikestation.repository.StationRepository;

@Controller
public class BikeController {

    @Autowired
    SlotRepository slotRepository;

    @Autowired
    StationRepository stationRepository;

    @Autowired
    BikeRepository bikeRepository;

    @GetMapping(path = "/bikes")
    public @ResponseBody
    Iterable<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    @GetMapping(path="/addbike")
    public @ResponseBody String addNewBike (@RequestParam long id, @RequestParam long idSlot){

        if (stationRepository.existsById(id) && slotRepository.existsById(idSlot)) {
            Bike n = Bike.getLimInstance();

            n.setStation(stationRepository.getOne(id));
            n.setSlot(slotRepository.getOne(idSlot));
            slotRepository.getOne(idSlot).setBike(n);
            bikeRepository.save(n);

            return "Saved";
        }
        else {
            return "wrong id";
        }
    }




}