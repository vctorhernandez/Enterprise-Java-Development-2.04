package org.example;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Person> personList = new ArrayList<>();
    private int nextId = 1;

    public void addPerson(Person person) {
        personList.add(person);
        // This ensures that nextId will be unique
        if (person.getId() >= nextId) {
            nextId = person.getId() + 1;
        }
    }

    public Person clone(Person person) {
        return new Person(nextId++, person.getName(), person.getAge(), person.getOccupation());
    }

    public Person findByName(String name) {
        if (name == null || !name.matches("^[^\\s]+\\s[^\\s]+$")) {
            throw new IllegalArgumentException("Name must be in the format 'firstName lastName'");
        }

        for (Person person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public void writePersonToFile(Person person) {
        try (java.io.FileWriter writer = new java.io.FileWriter("person_" + person.getId() + ".txt")) {
            writer.write(person.toString());
        } catch (java.io.IOException e) {
            System.err.println("Error writing person to file: " + e.getMessage());
        }
    }
}
