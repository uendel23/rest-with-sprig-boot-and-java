package br.com.del.rest_with_sprig_boot_and_java.controller;

import br.com.del.rest_with_sprig_boot_and_java.model.Person;
import br.com.del.rest_with_sprig_boot_and_java.services.PersonServices;
import br.com.del.rest_with_sprig_boot_and_java.vo.vo1.PersonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController{

    @Autowired
    private PersonServices service;

    @GetMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVo findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVo> findAll() {
        return service.findAll();
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVo create(@RequestBody Person personVo) {
        return service.create(personVo);
    }

    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVo update(@RequestBody Person personVo) {
        return service.update(personVo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PersonVo> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
