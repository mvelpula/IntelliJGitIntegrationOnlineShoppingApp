package com.madhu.onlineshopping.com.madhu.onlineshopping.service;

import com.madhu.onlineshopping.com.madhu.onlineshopping.entity.Students;
import com.madhu.onlineshopping.com.madhu.onlineshopping.repo.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
@Component
public class StudentService {

    private final StudentsRepository sRepo;

    private final EntityManager eManager;

    public StudentService(StudentsRepository sRepo, EntityManager eManager) {
        this.sRepo = sRepo;
        this.eManager = eManager;
    }

    public void addStudents(Students students) {

        Students s = new Students();

        s.setCollege(students.getCollege());
        s.setId(students.getId());
        s.setName(students.getName());

        sRepo.save(s);

    }

    public List<Students> getAllStudents() {

        List<Students> sList = sRepo.findAll();

        return sList;
    }

    public Page<Students> getAllStudentsPagination(int pageNum, int size) {

        //   List<Students> sList = sRepo.findAll();

        Pageable sortedByNameDesc = PageRequest.of(pageNum, size, Sort.unsorted());

        return sRepo.findAll(sortedByNameDesc);
    }

    public List<Students> getAlStudentsByCollege(String collegeName) {


        Query q = eManager.createNamedQuery("student.findByCollege");

        q.setParameter(1, collegeName);

        List list = q.getResultList();

        //sRepo.findAll(); returns Page<T> object by default here T is Students

        return list;

    }

    public void deleteStudent(int sid){

        sRepo.deleteById(sid);

    }
}
