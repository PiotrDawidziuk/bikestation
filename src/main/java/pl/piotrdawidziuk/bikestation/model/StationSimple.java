package pl.piotrdawidziuk.bikestation.model;

public class StationSimple {

    String name;
    int freeSlots;
    int occupiedSlots;
    int bikes;

    public StationSimple(String name, int freeSlots, int occupiedSlots, int bikes) {
        this.name = name;
        this.freeSlots = freeSlots;
        occupiedSlots = occupiedSlots;
        this.bikes = bikes;
    }

    public StationSimple() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(int freeSlots) {
        this.freeSlots = freeSlots;
    }

    public int getOccupiedSlots() {
        return occupiedSlots;
    }

    public void setOccupiedSlots(int occupiedSlots) {
        occupiedSlots = occupiedSlots;
    }

    public int getBikes() {
        return bikes;
    }

    public void setBikes(int bikes) {
        this.bikes = bikes;
    }
}
