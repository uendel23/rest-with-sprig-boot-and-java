package br.com.del.rest_with_sprig_boot_and_java.services;
import br.com.del.rest_with_sprig_boot_and_java.exceptions.ResourceNotFoundException;
import br.com.del.rest_with_sprig_boot_and_java.mapper.ModelMapper;
import br.com.del.rest_with_sprig_boot_and_java.mapper.custon.PersonMepper;
import br.com.del.rest_with_sprig_boot_and_java.model.Person;
import br.com.del.rest_with_sprig_boot_and_java.repository.PersonRepository;
import br.com.del.rest_with_sprig_boot_and_java.vo.vo1.PersonVo;
import br.com.del.rest_with_sprig_boot_and_java.vo.vo2.PersonVoV2;
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
    @Autowired
    private PersonMepper mapper;


    @GetMapping
    public List<PersonVo> findAll() {
        logger.info("finding all person");
        return ModelMapper.parseListObject(repository.findAll(), PersonVo.class);

    }


    public PersonVo findById(Long id) {
        logger.info("finding one person");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        return ModelMapper.parseObject(entity, PersonVo.class);


    }


    public PersonVo create(PersonVo personVo) {

        logger.info("creating one person!");
        var entity = ModelMapper.parseObject(personVo, Person.class);
        var vo = ModelMapper.parseObject(repository.save(entity), PersonVo.class);
        return vo;
    }


    public PersonVo update(Person personVo) {
        logger.info("Updating one person!");

        var entity = repository.findById(personVo.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        entity.setFirstName(personVo.getFirstName());
        entity.setLastName(personVo.getLastName());
        entity.setAddress(personVo.getAddress());
        entity.setGender(personVo.getGender());

        var vo = ModelMapper.parseObject(repository.save(entity), PersonVo.class);
        return vo;

    }


    public void delete(Long id) {

        logger.info("Deliting one person!");

        repository.deleteById(id);
    }


    public PersonVoV2 createV2(PersonVoV2 personV2) {
        logger.info("creating one person with versio two V2!");

        var entity = mapper.convertVoToEntity(personV2);
        var vo = mapper.convertEntityToVo(repository.save(entity));
        return vo;


    }
}
