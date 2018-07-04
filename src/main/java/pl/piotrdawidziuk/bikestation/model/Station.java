package pl.piotrdawidziuk.bikestation.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Station {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany (cascade = CascadeType.ALL)
    private List<Slot> slots;

    @OneToMany (cascade = CascadeType.ALL)
    private List<Bike> bikes;


    public Station(String name) {
        this.name = name;
    }

    public Station() {
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

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }

    @Override
    public String toString (){
        String s = "Name: "+this.getName()+" ID: "+this.getId()+ " Slots: "+this.getSlots().size();
        return s;
    }
}
