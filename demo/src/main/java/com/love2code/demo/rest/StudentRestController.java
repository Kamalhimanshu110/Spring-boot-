package com.love2code.demo.rest;

import com.love2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private  List<Student> thestudent;
    @PostConstruct
    public void loadData(){
        thestudent=new ArrayList<>();
        thestudent.add(new Student("himanshu","singh"));
        thestudent.add(new Student("priyanshu","singh"));
        thestudent.add(new Student("gaurav","singh"));
    }
    //define endpoint for "/student"- return a list of students
    @GetMapping("/students")
    public List<Student> getstudents()
    {
        return thestudent;
    }
    @GetMapping("/students/{studentId}")
    public Student getstudent(@PathVariable int studentId ){
        if((studentId >= thestudent.size())||(studentId<0))
        {
            throw new StudentNotFoundException("Student id not found - "+studentId );
        }
        return thestudent.get(studentId);
    }

}
