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

    @Autowired
    StationRepository stationRepository;

    @GetMapping(path = "/slots")
    public @ResponseBody
    Iterable<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    @GetMapping(path="/addslot")
    public @ResponseBody String addNewSlot (@RequestParam long id){

        if (stationRepository.existsById(id)) {

            Slot n = new Slot();

            n.setStation(stationRepository.getOne(id));
            n.setOccupied(false);
            slotRepository.save(n);

            return "Saved";
        }
        else {
            return "wrong id";
        }
    }

    @GetMapping(path="/isoccupied")
    public @ResponseBody String isSlotOccupied (@RequestParam long id){

        if (slotRepository.existsById(id)) {
            if (slotRepository.getOne(id).isOccupied() == true) {
                return "Slot Occupied";
            }
            return "Slot free";
        }
        else {
            return "wrong id";
        }
    }



}