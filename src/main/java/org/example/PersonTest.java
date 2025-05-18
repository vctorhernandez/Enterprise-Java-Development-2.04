package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void testSetAgeThrowsExceptionForNegativeAge() {
        Person person = new Person(1, "Víctor Hernández", 22, "Engineer");
        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-5);
        });
    }
    @Test
    public void testFindByNameReturnsCorrectPerson() {
        PersonList personList = new PersonList();
        Person person = new Person(1, "Víctor Hernández", 22, "Engineer");
        personList.addPerson(person);

        Person found = personList.findByName("Víctor Hernández");
        assertNotNull(found);
        assertEquals("Víctor Hernández", found.getName());
    }

    @Test
    public void testFindByNameThrowsExceptionForInvalidFormat() {
        PersonList personList = new PersonList();

        assertThrows(IllegalArgumentException.class, () -> {
            personList.findByName("Víctor");  // Only one name, should fail
        });

        assertThrows(IllegalArgumentException.class, () -> {
            personList.findByName("Víctor  Hernández");  // Extra space, should fail
        });

        assertThrows(IllegalArgumentException.class, () -> {
            personList.findByName("");  // Empty, should fail
        });
    }

    @Test
    public void testCloneCreatesPersonWithNewId() {
        PersonList personList = new PersonList();
        Person original = new Person(1, "Víctor Hernández", 22, "Engineer");
        personList.addPerson(original);

        Person clone = personList.clone(original);

        assertNotEquals(original.getId(), clone.getId());
        assertEquals(original.getName(), clone.getName());
        assertEquals(original.getAge(), clone.getAge());
        assertEquals(original.getOccupation(), clone.getOccupation());
    }


}
