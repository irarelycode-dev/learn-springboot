package jpaandhibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

@Repository
public class PersonJdbcDao {

    static class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setDob(rs.getTime("dob"));
            return person;
        }
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        List<Person> persons = jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
        System.out.println("Check:" + persons.size());
        return persons;
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?", new Object[]{id});
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person(id,first_name,last_name,dob) values(?,?,?,?)", new Object[]{person.getId(), person.getFirstName(), person.getLastName(), new Timestamp(person.getDob().getTime())});
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person set first_name=?,last_name=? where id=?", new Object[]{person.getFirstName(), person.getLastName(), person.getId()});
    }

}

//BeanPropertyRowMapper is used to map fields in our table rows to the fields in Person entity
//entity class must have an empty argument constructor
