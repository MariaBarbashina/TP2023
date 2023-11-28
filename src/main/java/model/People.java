package model;

import java.util.Objects;

public class People {
    private Long id;
    private String name;
    private String last_name;
    private String number;

    public People(Long id, String name, String last_name, String number) {
        this(name, last_name, number);
        this.id = id;
    }

    public People(String name, String last_name, String number) {
        this.name = name;
        this.last_name = last_name;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_Lastname() {
        return last_name;
    }

    public void set_Lastname(String last_name) {
        this.last_name = last_name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people1 = (People) o;
        return Objects.equals(id, people1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
