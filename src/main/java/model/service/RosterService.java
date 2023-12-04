package model.service;

import model.Roster;
import model.RosterRepository;

import java.util.List;

public class RosterService {
    private final RosterRepository repository;

    public RosterService(RosterRepository repository) {
        this.repository = repository;
    }

    public Roster getById(Long id) {
        return repository.find(id);
    }

    public List<Roster> getAll() {
        List<Roster> list = repository.list();
        return list;
    }
}
