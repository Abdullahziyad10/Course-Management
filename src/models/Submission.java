/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Submission {

    private int id;
    private String student_name;
    private String answer;
    private int assignment_id;
    private Timestamp submitted_datetime;

    public Submission() {
    }

    public Submission(int id, String student_name, String answer, int assignment_id, Timestamp submitted_datetime) {
        this.id = id;
        this.student_name = student_name;
        this.answer = answer;
        this.assignment_id = assignment_id;
        this.submitted_datetime = submitted_datetime;
    }

    public int getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Timestamp getSubmitted_datetime() {
        return submitted_datetime;
    }

    public void setSubmitted_datetime(Timestamp submitted_datetime) {
        this.submitted_datetime = submitted_datetime;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getSubmitted_datetime_format() {
        String s = new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(this.getSubmitted_datetime());
        return s.toUpperCase();
    }

    @Override
    public String toString() {
        return "SubmissionDTO{" + "id=" + id + ", student_name=" + student_name + ", answer=" + answer + ", assignment_id=" + assignment_id + ", submitted_datetime=" + submitted_datetime + '}';
    }

}
