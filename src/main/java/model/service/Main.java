package model.service;

import model.Roster;
import model.RosterRepository;
import model.DB.RosterRepositoryImpl;
import model.DB.ConnectionM;


public class Main {

    public static void main(String[] args) {

        ConnectionM manager;
        manager = new ConnectionM();

        RosterService service =
                new RosterService(new RosterRepositoryImpl(manager.getConnection()));
        for (Roster b : service.getAll()) System.out.println("Id: " + b.getId() + ", title: " + b.getTitle());
        System.out.println("============");
        Roster roster = service.getById(3L);
        System.out.println("Roster by id = 3: " + roster.getId() + " - " + roster.getTitle());
    }
}
