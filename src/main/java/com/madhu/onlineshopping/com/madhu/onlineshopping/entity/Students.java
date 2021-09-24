package com.madhu.onlineshopping.com.madhu.onlineshopping.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NamedNativeQuery(name="student.findByCollege",
        query = "select * from student where college = ?1")
public class Students {

    @Id
    int id;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    String college;
    String name;
    public Students() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
