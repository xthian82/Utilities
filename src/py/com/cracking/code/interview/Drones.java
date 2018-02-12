package py.com.cracking.code.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Drones {
    public static void main(String[] args) {

        List<Drone> drones = new ArrayList<>();
        drones.add(new Drone(4, 11));

        drones.add(new Drone(2, 15));
        drones.add(new Drone(5, 16));
        drones.add(new Drone(3, 40));
        drones.add(new Drone(1, 20));
        drones.add(new Drone(9, 60));
        drones.add(new Drone(6, 22));

        List<Integer> inMainentance = new ArrayList<>();
        inMainentance.add(1);
        inMainentance.add(5);
        inMainentance.add(9);

        int number = 3;

        List<Integer> greatest = greatestFlightRangeDrones(number, drones, inMainentance);

        for (int i=0; i<greatest.size(); i++) {
            System.out.println(greatest.get(i));
        }
    }

    static List<Integer> greatestFlightRangeDrones(Integer numberOfRequiredDrones, List<Drone> drones, List<Integer> inMaintenanceDrones) {
        List<Integer> ids = new LinkedList<>();
        Map<Integer, Integer> dr = new TreeMap<>();

        drones.stream().filter(drone -> !inMaintenanceDrones.contains(drone.getId()))
                .sorted(Comparator.comparing(Drone::getFlightRange)
                .reversed())
                .limit(numberOfRequiredDrones)
                .forEach(drone -> ids.add(drone.getId()));

        return ids;
    }

    private static class Drone {
        private int id;
        private int flightRange;

        public Drone(int id, int flightRange) {
            this.id = id;
            this.flightRange = flightRange;
        }

        public int getId() {
            return id;
        }

        public int getFlightRange() {
            return flightRange;
        }
    }
}
