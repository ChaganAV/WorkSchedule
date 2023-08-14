package com.example.WorkSchedule.repositoryes;

import com.example.WorkSchedule.models.Person;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PersonRepository extends CrudRepository<Person,Long> {
    @Query("select * from person")
    List<Person> findPersons();

    @Query("select * from person where fio = :fio")
    List<Person> findPersonByFio(String fio);

    @Query("select * from person where fullname = :fullname")
    List<Person> findPersonByFullname(String fullname);

    @Query("select * from person where lastname = :lastname")
    List<Person> findPersonByLastname(String lastname);

    @Modifying
    @Query("insert into person (lastname,firstname,secondname,fio,fullname,tabnum) values(:lastname,:firstname,:secondname,:fio,:fullname,:tabnum)")
    void addPerson(String lastname, String firstname, String secondname, String fio, String fullname, String tabnum);

    @Modifying
    @Query("update person set tabnum = :tabnum where id = :id")
    void changePersonTabnum(long id, String tabnum);

    @Modifying
    @Query("update person SET lastname=:lastname,firstname=:firstname,secondname=:secondname,fio=:fio,fullname=:fullname where id=:id")
    void changePerson(long id, String lastname, String firstname, String secondname, String fio, String fullname);

    @Modifying
    @Query("update person SET fio=:fio where id=:id")
    void changePersonFio(long id, String fio);

    @Modifying
    @Query("update person SET fullname=:fullname where id=:id")
    void changePersonFullname(long id, String fullname);

    @Modifying
    @Query("update person SET lastname=:lastname where id=:id")
    void changePersonLastname(long id, String lastname);

    @Modifying
    @Query("delete from person where id = :id")
    void deletePerson(long id);
}
