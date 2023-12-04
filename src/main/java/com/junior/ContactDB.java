package com.junior;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDB {
    private Connection connection;

    public ContactDB() {
        try {
            connection = MySQLConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addContact(Contact contact) {
        try {
            String insertSQL = "INSERT INTO contacts (firstName, lastName, phoneNumber1, phoneNumber2, phoneNumber3) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());
            for (int i = 0; i < 3; i++) {
                if (i < contact.getPhoneNumbers().length) {
                    preparedStatement.setString(3 + i, contact.getPhoneNumbers()[i]);
                } else {
                    preparedStatement.setNull(3 + i, Types.VARCHAR);
                }
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(String lastName) {
        try {
            String deleteSQL = "DELETE FROM contacts WHERE lastName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, lastName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editContact(String lastName, Contact newContact) {
        deleteContact(lastName);
        addContact(newContact);
    }

    public List<Contact> searchByLastName(String lastName) {
        List<Contact> contacts = new ArrayList<>();
        try {
            String selectSQL = "SELECT * FROM contacts WHERE lastName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String[] phoneNumbers = {
                        resultSet.getString("phoneNumber1"),
                        resultSet.getString("phoneNumber2"),
                        resultSet.getString("phoneNumber3")
                };
                contacts.add(new Contact(firstName, lastName, phoneNumbers));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public List<Contact> searchByPhoneNumber(String phoneNumber) {
        List<Contact> contacts = new ArrayList<>();
        try {
            String selectSQL = "SELECT * FROM contacts WHERE phoneNumber1 = ? OR phoneNumber2 = ? OR phoneNumber3 = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String[] phoneNumbers = {
                        resultSet.getString("phoneNumber1"),
                        resultSet.getString("phoneNumber2"),
                        resultSet.getString("phoneNumber3")
                };
                contacts.add(new Contact(firstName, lastName, phoneNumbers));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        try {
            String selectSQL = "SELECT * FROM contacts";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String[] phoneNumbers = {
                        resultSet.getString("phoneNumber1"),
                        resultSet.getString("phoneNumber2"),
                        resultSet.getString("phoneNumber3")
                };
                contacts.add(new Contact(firstName, lastName, phoneNumbers));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}