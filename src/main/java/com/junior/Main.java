package com.junior;

import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ContactDB contactDAO = new ContactDB();

        // Добавление контактов
        Contact contact1 = new Contact("Иван", "Иванов", new String[]{"8980", "538", "9220"});
        contactDAO.addContact(contact1);

        Contact contact2 = new Contact("Петр", "Петров", new String[]{"8920", "222", "3331"});
        contactDAO.addContact(contact2);

        // Вывод всех контактов в консоль в алфавитном порядке
        List<Contact> contacts = contactDAO.getAllContacts();
        contacts.sort((c1, c2) -> {
            int lastNameComparison = c1.getLastName().compareTo(c2.getLastName());
            if (lastNameComparison != 0) {
                return lastNameComparison;
            }
            for (int i = 0; i < 3; i++) {
                int phoneComparison = c1.getPhoneNumbers()[i].compareTo(c2.getPhoneNumbers()[i]);
                if (phoneComparison != 0) {
                    return phoneComparison;
                }
            }
            return 0;
        });

        for (Contact contact : contacts) {
            System.out.println(contact.getFirstName() + " " + contact.getLastName() + " " + Arrays.toString(contact.getPhoneNumbers()));
        }
    }
}