package model;

import model.exception.RosterNotFoundExc;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class InMemoryRosterRepository implements RosterRepository{

    private final Storehouse storehouse = Storehouse.getInstance();
    @Override
    public Roster find(Long id) {
        return storehouse.rosters.stream()
                .filter(b -> Objects.equals(b.getId(), id))
                .findFirst()
                .orElseThrow(() -> new RosterNotFoundExc("No rosters found by id=" + id));
    }

    @Override
    public List<Roster> list() {
        return new ArrayList<>(storehouse.rosters);
    }

    @Override
    public void save(Roster roster) {
        if (roster.getId() == null) {
            roster.setId(storehouse.rosterIdGenerator.incrementAndGet());
        }
        storehouse.rosters.remove(roster);
        storehouse.rosters.add(roster);

    }

    @Override
    public void remove(Roster roster) {
        storehouse.rosters.remove(roster);

    }
}
