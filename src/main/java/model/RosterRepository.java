package model;

import java.util.List;

public interface RosterRepository {
    Roster find(Long id);

    List<Roster> list();

    void save(Roster roster);

    void remove(Roster roster);
}
