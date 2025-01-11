package br.com.del.rest_with_sprig_boot_and_java.services;

import br.com.del.rest_with_sprig_boot_and_java.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){

        logger.info("finding one person");

        Person person =  new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastNane("Costa");
        person.setAddress("Irecê - Bahia - Brasil");
        person.setGender("male");
        return person;

    };

}
