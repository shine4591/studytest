package com.andy.prototype.model;

import com.andy.prototype.Prototype;

import java.io.Serializable;

public class Student implements Serializable, Prototype {

    private String name;
    private int age;
    private boolean ismale;
    private String country;
    private ClassRoom classRoom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isIsmale() {
        return ismale;
    }

    public void setIsmale(boolean ismale) {
        this.ismale = ismale;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public Prototype clone() {
        Student s = new Student();
        s.setName(this.name);
        s.setIsmale(this.ismale);
        s.setCountry(this.country);
        s.setAge(this.age);
        s.setClassRoom(this.classRoom);
        return s;
    }
}
