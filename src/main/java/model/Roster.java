package model;

import java.util.List;
import java.util.Objects;

public class Roster {
    private Long id;
    private String title;

    private List<People> people;

    public Roster(String title, List<People> people) {
        this.title = title;
        this.people = people;
    }

    public Roster(Long id, String title, List<People> people) {
        this.id = id;
        this.title = title;
        this.people = people;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roster roster = (Roster) o;
        return Objects.equals(id, roster.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
