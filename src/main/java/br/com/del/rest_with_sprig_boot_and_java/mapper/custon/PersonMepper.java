package br.com.del.rest_with_sprig_boot_and_java.mapper.custon;

import br.com.del.rest_with_sprig_boot_and_java.model.Person;
import br.com.del.rest_with_sprig_boot_and_java.vo.vo2.PersonVoV2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMepper {

    public PersonVoV2 convertEntityToVo(Person person){
        PersonVoV2 vo = new PersonVoV2();

        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthDay(new Date());

        return vo;
    }

    public Person convertVoToEntity(PersonVoV2 person){
        Person entity = new Person();

        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        //entity.setBirthDay(new Date());

        return entity;
    }
}
