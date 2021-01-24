/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.Submission;


public class SubmissionDBHandler extends DB {

    public ArrayList<Submission> getAllSubmissionByAssignemntId(int id) {
        ArrayList<Submission> array = null; //statement
        Submission obj = null;
        String query = "SELECT id,student_name,answer,assignment_id , "
                + " date_time "
                + " as submissions_time FROM `submissions` WHERE "
                + " assignment_id=?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(query);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs != null) {
                array = new ArrayList<Submission>();
                while (rs.next()) {

                    obj = new Submission();
                    obj.setId(rs.getInt(1));
                    obj.setStudent_name(rs.getString(2));
                    obj.setAnswer(rs.getString(3));
                    obj.setAssignment_id(rs.getInt(4));
                    obj.setSubmitted_datetime(rs.getTimestamp(5));
                    array.add(obj);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubmissionDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubmissionDBHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SubmissionDBHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (array == null || array.isEmpty()) {
            return null;
        }
        return array;
    }

    public boolean CreateSubmission(Submission obj) {
        int affectedRows = 0;
        try {

            String query = "INSERT INTO `submissions`(`id`, `student_name`, `answer`, `assignment_id`) VALUES (NULL, ?, ?,?)";
            PreparedStatement pst = null;

            pst = conn.prepareStatement(query);
            pst.setString(1, obj.getStudent_name());
            pst.setString(2, obj.getAnswer());
            pst.setInt(3, obj.getAssignment_id());

            affectedRows = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SubmissionDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return affectedRows > 0;
    }
}
