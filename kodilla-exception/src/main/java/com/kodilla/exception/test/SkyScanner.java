package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class SkyScanner {

    public static void main(String[] args) {
        SkyScanner scanner = new SkyScanner();

        Flight flight1 = new Flight("KRK", "GDA");
        Flight flight2 = new Flight("GDA", "WAW");
        Flight flight3 = new Flight("KRK", "XYZ");

        checkFlight(scanner, flight1);
        checkFlight(scanner, flight2);
        checkFlight(scanner, flight3);
    }


    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> destinationMap = new HashMap<>();
        destinationMap.put("KRK", true);
        destinationMap.put("GDA", true);
        destinationMap.put("WAW", false);

        String arrival = flight.getArrivalAirport();

        if (!destinationMap.containsKey(arrival)) {
            throw new RouteNotFoundException();
        }
        return destinationMap.get(arrival);
    }

    private static void checkFlight(SkyScanner scanner, Flight flight) {
        try {
            boolean possible = scanner.findFlight(flight);
            System.out.println(possible);
        } catch (RouteNotFoundException e) {
            System.out.println("Błąd");
        } finally {
            System.out.println("Koniec");
        }
    }
}
