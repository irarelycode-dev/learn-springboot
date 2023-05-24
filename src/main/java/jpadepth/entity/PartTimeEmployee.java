package jpadepth.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class PartTimeEmployee extends Employee {

    BigDecimal hourlyWage;

    protected PartTimeEmployee() {
        super();
    }

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

}
