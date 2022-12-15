package com.example.assignment4.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor

public class EmployeesModel {
    @NotNull(message = "ID is empty")
    @Size(min = 2, message = "ID most be more then 2")
    private String ID ;

    @NotNull(message = "name is empty")
    @Size(min = 4, message = "size most be more then 4")
    private String name;
    @NotNull(message = "age is empty")
    @Digits(integer = 2,fraction = 0)
    @Min(25)
    private int age;

    @AssertFalse(message = "can not be on leave")
    private boolean onLeave ;
    @NotNull(message = "can not be null")
    @Range(min=1970,max = 2022,message = "year cant be in te future")
    private int employmentYear;
    @NotNull(message = "can not be null")
    @Min(value = 0)
     private int annualLeave;


}
