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
        // This returns a JSON or XML with the users
        return stationRepository.findAll();
    }

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewStation (@RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Station n = new Station();
        n.setName(name);
       // n.setId(10l);
        stationRepository.save(n);
        return "Saved";
    }




}