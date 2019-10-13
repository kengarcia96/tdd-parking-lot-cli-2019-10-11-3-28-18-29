package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_park_car_to_parking_lot_by_parking_boy() {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        // when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        // then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_fetch_car_to_parking_lot_by_parking_boy() {
        // given
        Car car1 = new Car();
        Car car2 = new Car();

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        // when
        ParkingTicket parkingTicket1 = parkingBoy.park(car1);
        ParkingTicket parkingTicket2 = parkingBoy.park(car2);
        Car carGet = parkingBoy.fetch(parkingTicket1);

        // then
        assertEquals(car1, carGet);
    }

    @Test
    void should_return_no_car_when_no_ticket_is_given() {
        // given

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        // when
        Car carGet = parkingBoy.fetch(null);

        // then
        assertNull(carGet);
    }

    @Test
    void should_return_no_car_when_wrong_ticket_is_given() {
        // given;

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        // when

        Car carGet = parkingBoy.fetch(new ParkingTicket());

        // then
        assertNull(carGet);
    }

    @Test
        void should_return_no_car_when_ticket_is_used() {
        // given;
        Car car1 = new Car();

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        // when
        ParkingTicket parkingTicket1 = parkingBoy.park(car1);
        Car carGet = parkingBoy.fetch(parkingTicket1);
        Car carGet2 = parkingBoy.fetch(parkingTicket1);

        // then
        assertNotNull(carGet);
        assertNull(carGet2);
    }

    @Test
    void should_return_null_when_capacity_exceed_limit() {
        // given;

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        // when

        for(int i = 0; i < 10; i++ ){
            Car car = new Car();
            ParkingTicket parkingTicket = parkingBoy.park(car);
        }

        Car car1 = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car1);

        assertNull(parkingTicket);
    }

    @Test
    void should_get_error_message_when_no_ticket_is_given() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        // when
        Car carGet = parkingBoy.fetch(null);

        // then
        assertNull(carGet);
        assertEquals(parkingBoy.getLastErrorMessage(),"Please provide your parking ticket.");
    }

    @Test
    void should_get_error_message_when_wrong_ticket_is_given() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        // when
        Car carGet = parkingBoy.fetch(new ParkingTicket());

        // then
        assertNull(carGet);
        assertEquals(parkingBoy.getLastErrorMessage(),"Unrecognized parking ticket");
    }
}
