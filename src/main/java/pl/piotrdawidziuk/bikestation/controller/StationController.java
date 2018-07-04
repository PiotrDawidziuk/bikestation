package pl.piotrdawidziuk.bikestation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.piotrdawidziuk.bikestation.model.Bike;
import pl.piotrdawidziuk.bikestation.model.Slot;
import pl.piotrdawidziuk.bikestation.model.Station;
import pl.piotrdawidziuk.bikestation.model.StationSimple;
import pl.piotrdawidziuk.bikestation.repository.StationRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StationController {

    @Autowired
    StationRepository stationRepository;

    @GetMapping(path = "/stations")
    public @ResponseBody
    List<StationSimple> getAllStations() {

        List<StationSimple> stationsSimple = new ArrayList<>();
        for (Station station : stationRepository.findAll()) {
            int freeSlots = 0;
            int occupiedSlots = 0;
            int bikes = 0;
            for (Slot slot : station.getSlots()) {
                if(slot.getBike() == null) {
                    freeSlots++;
                } else {
                    occupiedSlots++;
                }
            }
            for (Bike bike: station.getBikes()){
                bikes++;
            }

            StationSimple stationSimple = new StationSimple(station.getName(), freeSlots, occupiedSlots, bikes);
            stationsSimple.add(stationSimple);
        }


        return stationsSimple;
    }

    @GetMapping (path = "/stationbikes")
    public @ResponseBody List showBikesFromStation(@RequestParam long id) {
        Station s = stationRepository.getOne(id);
        List list = s.getBikes();

        return list;
    }

    @PostMapping(path="/station")
    public @ResponseBody String addNewStation (@RequestParam String name) {

        Station n = new Station();
        n.setName(name);
        List slots = new ArrayList<Slot>();
        Slot slot1 = new Slot();
        slots.add(slot1);
        n.setSlots(slots);
        slot1.setStation(n);
        stationRepository.save(n);
        return "Saved";
    }

    @DeleteMapping(path="/station/{id}")
    public @ResponseBody String Delete (@PathVariable("id") Long id) {

        Station n = stationRepository.getOne(id);
        stationRepository.delete(n);
        return "Deleted";
    }

    @PutMapping (path = "/station/{id}")
    public @ResponseBody String Update (@PathVariable("id") Long id) {
        Station n = stationRepository.getOne(id);
        stationRepository.save(n);
        return "Updated";
    }

    @GetMapping (path = "/station/{id}")
    public @ResponseBody Station FindOne (@PathVariable("id") Long id) {
        Station n = stationRepository.getOne(id);
        return n;
    }


}