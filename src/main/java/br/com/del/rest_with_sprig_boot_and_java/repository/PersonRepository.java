package br.com.del.rest_with_sprig_boot_and_java.repository;

import br.com.del.rest_with_sprig_boot_and_java.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
