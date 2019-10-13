package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {

        if(parkingLot.getAvailableParkingPosition() == 0){
            lastErrorMessage = "Not enough position.";
        }

        return parkingLot.addCar(car);
    }

    public Car fetch(ParkingTicket ticket) {
        Car carsGot = parkingLot.fetchCar(ticket);

        if (ticket == null){
            lastErrorMessage = "Please provide your parking ticket.";
            return null;
        }

        else if (carsGot == null) {
            lastErrorMessage = "Unrecognized parking ticket";
            return null;
        }
        else {
            return carsGot;
        }
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }


}
