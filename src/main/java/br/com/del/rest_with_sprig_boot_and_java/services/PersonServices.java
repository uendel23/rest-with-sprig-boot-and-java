package br.com.del.rest_with_sprig_boot_and_java.services;

import br.com.del.rest_with_sprig_boot_and_java.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }



    public Person findById(String id) {

        logger.info("finding one person");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastNane("Costa");
        person.setAddress("Irecê - Bahia - Brasil");
        person.setGender("male");
        return person;

    }

    public Person create (Person person){

        logger.info("creating one person!");

        return person;
    }

    public Person update (Person person){

        logger.info("Updating one person!");

        return person;
    }

    public void delete (String id){

        logger.info("Deliting one person!");

    }





    public Person mockPerson(int i) {

        logger.info("finding all people!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("person name " + i);
        person.setLastNane("Lest name "+ i);
        person.setAddress("Some address in Brasil "+ i);
        person.setGender("male");
        return person;
    }


}
