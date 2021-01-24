/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class Course {

    private int id;
    private String name;
    private int assignment_count;

    public Course() {
    }

    public Course(int id, String name, int assignment_count) {
        this.id = id;
        this.name = name;
        this.assignment_count = assignment_count;
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

    public int getAssignment_count() {
        return assignment_count;
    }

    public void setAssignment_count(int assignment_count) {
        this.assignment_count = assignment_count;
    }

    @Override
    public String toString() {
        return "CourseDTO{" + "id=" + id + ", name=" + name + ", assignment_count=" + assignment_count + '}' + "\n";
    }

}
