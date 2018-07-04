package pl.piotrdawidziuk.bikestation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.piotrdawidziuk.bikestation.model.Station;
import pl.piotrdawidziuk.bikestation.repository.StationRepository;

@Controller
public class StationController {

    @Autowired
    StationRepository stationRepository;


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Station> getAllStations() {
        return stationRepository.findAll();
    }

    @GetMapping(path="/add")
    public @ResponseBody String addNewStation (@RequestParam String name) {

        Station n = new Station();
        n.setName(name);
        stationRepository.save(n);
        return "Saved";
    }




}