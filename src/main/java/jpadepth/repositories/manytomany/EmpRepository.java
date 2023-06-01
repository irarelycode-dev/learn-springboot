package jpadepth.repositories.manytomany;

import jpadepth.entity.manytomany.employees.Employee;
import jpadepth.entity.manytomany.employees.EmployeePkId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee, EmployeePkId> {
}
