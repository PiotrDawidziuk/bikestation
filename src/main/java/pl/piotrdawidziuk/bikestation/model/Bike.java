package pl.piotrdawidziuk.bikestation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bike {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
