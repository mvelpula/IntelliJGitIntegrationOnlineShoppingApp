package com.madhu.onlineshopping.com.madhu.onlineshopping.controller;

import com.madhu.onlineshopping.com.madhu.onlineshopping.service.StudentService;
import com.madhu.onlineshopping.com.madhu.onlineshopping.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maaStrore")
public class UserProfileController {

    @Autowired
    private StudentService sService;

    @GetMapping("/login")
    public ResponseEntity<String> loginService() {

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @GetMapping("/studentsList")
    public ResponseEntity<List<Students>> getStudentList(){


        List<Students> sList= sService.getAllStudents();

        return new ResponseEntity<>(sList, HttpStatus.OK);
    }

    @GetMapping("/byCollegeName/{cName}")
    public ResponseEntity<List<Students>> getAlStudentsByCollege(@PathVariable String cName){

        List<Students> sList = sService.getAlStudentsByCollege(cName);

        return new ResponseEntity<List<Students>>(sList, HttpStatus.OK);

    }

    @GetMapping("/pagination/{pageNum}/{size}")
    public ResponseEntity<Page<Students>> getAllStudentsPagination(@PathVariable int pageNum,
                                                                   @PathVariable int size){

        Page<Students> pagination= sService.getAllStudentsPagination(pageNum, size);

        return new ResponseEntity<Page<Students>>(pagination, HttpStatus.OK);
    }

    @PostMapping("/addStudents")
    public ResponseEntity<String> addStudents(@RequestBody Students students){

        sService.addStudents(students);

        return new ResponseEntity<>("Added Student Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{sid}")
    public ResponseEntity<String> deleteStudent(@PathVariable int sid){

sService.deleteStudent(sid);

return new ResponseEntity<>("Deletion of "+ sid +" success", HttpStatus.OK);
    }
}
