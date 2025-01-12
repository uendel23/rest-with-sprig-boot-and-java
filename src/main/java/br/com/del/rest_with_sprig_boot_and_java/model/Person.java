package br.com.del.rest_with_sprig_boot_and_java.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false,length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastNane;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 10)
    private String Gender;

    public Person() {
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

    public String getLastNane() {
        return lastNane;
    }

    public void setLastNane(String lastNane) {
        this.lastNane = lastNane;
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
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastNane, person.lastNane) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastNane, address);
    }
}
