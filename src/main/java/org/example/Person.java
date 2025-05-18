package org.example;

public class Person {
    int id;
    String name;
    int age;
    String occupation;

    public Person(int id, String name, int age, String occupation){
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getOccupation() { return occupation; }

    public boolean equals(Person person) {
        if (person == null) return false;
        return this.name.equals(person.name) &&
                this.age == person.age &&
                this.occupation.equals(person.occupation);
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nAge: " + age + "\nOccupation: " + occupation;
    }
}
