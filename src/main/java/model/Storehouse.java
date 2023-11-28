package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;


public class Storehouse {
    private static Storehouse instance;

    public static Storehouse getInstance() {
        if (instance == null) {
            instance = new Storehouse();
        }
        return instance;
    }

    Set<Roster> rosters;
    final AtomicLong rosterIdGenerator = new AtomicLong(4L);

    private Storehouse() {
        rosters = new HashSet<>();
        initBoxes();
    }

    private void initBoxes() {
        People p1 = new People(1L,"Polina", "Kolina", "8 960 769-86-00");
        People p2 = new People(2L,"Maria", "Barbashina", "8 980 537-91-20");
        People p3 = new People(3L,"Irina", "Maruink", "8 919 249-38-39");
        People p4 = new People(4L, "Oleg", "Vechiy", "8 950 384-22-23");

        Roster r1 = new Roster(1L, "roster 1", List.of(p1, p2));
        Roster r2 = new Roster(2L, "roster 2", List.of(p3, p4));

        rosters.add(r1);
        rosters.add(r2);
    }
}
