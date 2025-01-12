package br.com.del.rest_with_sprig_boot_and_java.services;

import br.com.del.rest_with_sprig_boot_and_java.exceptions.ResourceNotFoundException;
import br.com.del.rest_with_sprig_boot_and_java.model.Person;
import br.com.del.rest_with_sprig_boot_and_java.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {


    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;

    @GetMapping
    public List<Person> findAll() {
        logger.info("finding all person");
        return repository.findAll();
    }



    public Person findById(Long id) {

        logger.info("finding one person");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }


    public Person create(Person person) {

        logger.info("creating one person!");

        return repository.save(person);
    }


    public Person update(Person person) {

        logger.info("Updating one person!");

        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastNane(person.getLastNane());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);

    }


    public void delete(Long id) {

        logger.info("Deliting one person!");

        repository.deleteById(id);
    }


}
