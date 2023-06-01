package jpadepth.entity.manytomany.employees;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeePkId implements Serializable {
    private int employeeId;
    private int deptId;
}
