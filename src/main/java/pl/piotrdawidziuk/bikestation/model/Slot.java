package pl.piotrdawidziuk.bikestation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Slot {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Slot(String name) {
        this.name = name;
    }

    public Slot() {
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
}
