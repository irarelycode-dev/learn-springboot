package jpadepth.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class FullTimeEmployee extends Employee {

    BigDecimal salary;

    protected FullTimeEmployee() {
        super();
    }


    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

}
