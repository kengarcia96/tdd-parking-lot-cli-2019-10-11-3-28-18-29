package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingTicket addCar(Car car) {
        if (cars.size() < capacity){
            ParkingTicket parkingTicket = new ParkingTicket();
            cars.put(parkingTicket,car);
            return parkingTicket;
        }

        return null;

    }

    public Car fetchCar(ParkingTicket ticket) {
        Car car = cars.get(ticket);
        cars.remove(ticket);

        return car;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return cars.size() - capacity;
    }
}
