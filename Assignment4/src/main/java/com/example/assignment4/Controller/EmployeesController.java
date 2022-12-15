package com.example.assignment4.Controller;

import com.example.assignment4.ApiResponse;
import com.example.assignment4.Model.EmployeesModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class EmployeesController {
    ArrayList<EmployeesModel> emp = new ArrayList<>();
    @GetMapping("/employees")
    public ArrayList<EmployeesModel> getEmp(){
        return emp;
    }
    @PostMapping("/add")
    public ResponseEntity addEmp(@RequestBody @Valid EmployeesModel employeesModel , Errors errors){
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        emp.add(employeesModel);
        return ResponseEntity.status(200).body(new ApiResponse("Employee added"));
    }
    @PutMapping("/update/{index}")
    public ResponseEntity updateEmp(@PathVariable int index , @RequestBody @Valid EmployeesModel employeesModel , Errors errors ){
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
         emp.set(index,employeesModel);
        return ResponseEntity.status(200).body(new ApiResponse("user updated"));

    }
    @DeleteMapping("/delate/{index}")
    public ResponseEntity delateEmp(@PathVariable int index , @RequestBody EmployeesModel employeesModel){
        emp.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Employ delated"));

    }

}
