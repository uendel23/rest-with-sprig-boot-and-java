package br.com.del.rest_with_sprig_boot_and_java.vo.vo1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

//@JasonPropertyOrder define a orden como o jsn será estruturado
@JsonPropertyOrder({"id, first_name, last_name, Gender, address"})
public class PersonVo implements Serializable{

    private static final long serialVersionUID = 1L;


    private Long id;
    //@JsonProperty altera o nome do atributo no json
    @JsonProperty("first_name")
    private String firstName;
    //@JsonProperty altera o nome do atributo no json
    @JsonProperty("last_name")
    private String lastName;
    //@JsonIgnore omite o atributo na serelização do json
    @JsonIgnore
    private String address;
    private String Gender;


    public PersonVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVo person = (PersonVo) o;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address);
    }
}
