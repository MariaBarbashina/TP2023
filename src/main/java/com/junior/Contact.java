package com.junior;

import model.People;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Contact {
    private Long id;
    private String firstName;
    private String lastName;
    private String[] phoneNumbers;

    public Contact(Long id, String firstName, String lastName, String[] phoneNumbers) {
        this(firstName, lastName, phoneNumbers);
        this.id=id;
    }

    public Contact(String firstName, String lastName, String[] phoneNumbers){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contactT = (Contact) o;
        return Objects.equals(id, contactT.id);
    }
}