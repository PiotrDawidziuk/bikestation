package pl.piotrdawidziuk.bikestation.model;

import javax.persistence.*;

@Entity
public class Bike {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Station station;

    @OneToOne
    Slot slot;


    private static Bike limInstance;

    public static int bikeCounter = 0;

    public static synchronized Bike getLimInstance(){
        if(bikeCounter < 3 ){
            limInstance = new Bike();
        }
        return limInstance;
    }



    public Bike(String name) {
        this.name = name;
    }

    public Bike() {
        this.name = "bike";
        bikeCounter++;
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

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
