/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Assignment {

    private int id;
    private String name;
    private int course_id;
    private int submissions_counts;
    private Timestamp latest_submissions;

    public Assignment() {
    }

    public Assignment(int id, String name, int course_id, int submissions_counts, Timestamp latest_submissions) {
        this.id = id;
        this.name = name;
        this.course_id = course_id;
        this.submissions_counts = submissions_counts;
        this.latest_submissions = latest_submissions;
    }
    
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

   

    public Timestamp getLatest_submissions() {
        return latest_submissions;
    }

    public void setLatest_submissions(Timestamp latest_submissions) {
        this.latest_submissions = latest_submissions;
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

    public int getSubmissions_counts() {
        return submissions_counts;
    }

    public void setSubmissions_counts(int submissions_counts) {
        this.submissions_counts = submissions_counts;
    }
    
    public String getLatest_submissions_format() {
        if(this.latest_submissions==null)
            return " ";
        String s = new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(this.getLatest_submissions());
        return s.toUpperCase();
    }

    @Override
    public String toString() {
        return "AssignmentDTO{" + "id=" + id + ", name=" + name + ", course_id=" + course_id + ", submissions_counts=" + submissions_counts + ", latest_submissions=" + latest_submissions + '}' +"\n";
    }

    

}
