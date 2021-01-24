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

import models.Assignment;

/**
 *
 * @author silen
 */
public class AssignmentDBHandler extends DB {

    public ArrayList<Assignment> getAllAssigmnetsByCourseId(int id) {
        ArrayList<Assignment> array = null; //statement
        Assignment obj = null;
        String query = "SELECT a.* , count(s.assignment_id) as submissions_count,  max(s.date_time) as latest_submisiion "
        		+ " FROM assignments a  left join submissions s on a.id=s.assignment_id  where a.course_id=? group by a.id";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(query);
            st.setInt(1, id);
            System.out.println(st);
            rs = st.executeQuery();
            if (rs != null) {
                array = new ArrayList<Assignment>();
                while (rs.next()) {

                    obj = new Assignment();
                    obj.setId(rs.getInt(1));
                    obj.setName(rs.getString(2));
                    obj.setCourse_id(rs.getInt(3));
                    obj.setSubmissions_counts(rs.getInt(4));
                    obj.setLatest_submissions(rs.getTimestamp(5));
                    array.add(obj);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignmentDBHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignmentDBHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (array == null || array.isEmpty()) {
            return null;
        }
        return array;
    }

    public Assignment getAssigmnetByID(int id) {
        Assignment obj = null;
        String query = "SELECT a.* , count(s.assignment_id) as submissions_count, "
                + " max(s.date_time)"
                + " as latest_submisiion "
                + " FROM assignments a "
                + " left join submissions s on a.id=s.assignment_id "
                + " where a.id=?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(query);
            st.setInt(1, id);
            System.out.print(st);
            rs = st.executeQuery();
            if (rs != null) {

                if (rs.next()) {

                    obj = new Assignment();
                    obj.setId(rs.getInt(1));
                    obj.setName(rs.getString(2));
                    obj.setCourse_id(rs.getInt(3));
                    obj.setSubmissions_counts(rs.getInt(4));
                    obj.setLatest_submissions(rs.getTimestamp(5));

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignmentDBHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AssignmentDBHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return obj;
    }

    public boolean CreateAssignment(Assignment obj) {
        int affectedRows = 0;
        try {

            String query = "INSERT INTO `assignments`(`id`, `name`, `course_id`) VALUES (NULL, ?,?)";
            PreparedStatement pst = null;

            pst = conn.prepareStatement(query);
            pst.setString(1, obj.getName());
            pst.setInt(2, obj.getCourse_id());

            affectedRows = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return affectedRows > 0;
    }

}