package jpadepth.entity.manytomany.employees;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE_TBL")
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(EmployeePkId.class)
@Embeddable
public class Employee {

//    @Id
//    private int employeeId;
//    @Id
//    private int deptId;

    @EmbeddedId
    private EmployeePkId employeePkId;
    private String name;
    private String email;
    private String phone;

}
