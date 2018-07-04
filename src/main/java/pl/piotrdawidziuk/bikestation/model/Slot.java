package pl.piotrdawidziuk.bikestation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Slot {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    Station station;


    public Slot(String name) {
        this.name = name;
    }

    public Slot() {
        this.name = "slot";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
