package br.com.del.rest_with_sprig_boot_and_java.controller;

import br.com.del.rest_with_sprig_boot_and_java.model.Person;
import br.com.del.rest_with_sprig_boot_and_java.services.PersonServices;
import br.com.del.rest_with_sprig_boot_and_java.vo.vo1.PersonVo;
import br.com.del.rest_with_sprig_boot_and_java.vo.vo2.PersonVoV2;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices service;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVo> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVo findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVo create(@RequestBody PersonVo personVo) {
        return service.create(personVo);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVo update(@RequestBody Person personVo) {
        return service.update(personVo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PersonVo> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVoV2 createV2(@RequestBody PersonVoV2 personV2) {
        return service.createV2(personV2);
    }


}
