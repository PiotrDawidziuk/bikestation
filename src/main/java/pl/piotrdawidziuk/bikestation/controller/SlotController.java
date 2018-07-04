package pl.piotrdawidziuk.bikestation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.piotrdawidziuk.bikestation.model.Slot;
import pl.piotrdawidziuk.bikestation.model.Station;
import pl.piotrdawidziuk.bikestation.repository.SlotRepository;
import pl.piotrdawidziuk.bikestation.repository.StationRepository;

@Controller
public class SlotController {

    @Autowired
    SlotRepository slotRepository;


    @GetMapping(path = "/slots")
    public @ResponseBody
    Iterable<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    @GetMapping(path="/addslot")
    public @ResponseBody String addNewStation () {

        Slot n = new Slot();
        slotRepository.save(n);
        return "Saved";
    }




}