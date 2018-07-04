package pl.piotrdawidziuk.bikestation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.piotrdawidziuk.bikestation.model.Station;
import pl.piotrdawidziuk.bikestation.repository.StationRepository;

@Controller
public class BikeStationController {

    @Autowired
    StationRepository stationRepository;


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Station> getAllStations() {
        // This returns a JSON or XML with the users
        return stationRepository.findAll();
    }
}