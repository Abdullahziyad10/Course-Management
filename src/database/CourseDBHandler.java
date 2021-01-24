/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.Assignment;
import models.Course;

/**
 *
 * @author silen
 */
public class CourseDBHandler extends DB {
	
	public boolean CreateCourse(Course obj) {
        int affectedRows = 0;
        try {

            String query = "INSERT INTO `courses`(`name`) VALUES (?)";
            PreparedStatement pst = null;

            pst = conn.prepareStatement(query);
            pst.setString(1, obj.getName());


            affectedRows = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CourseDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return affectedRows > 0;
    }

    public ArrayList<Course> getAllCourse() {
        ArrayList<Course> array = null; //statement
        Course obj = null;
        String query = "SELECT c.* , count(a.course_id) FROM `courses` c "
                + "left join assignments a on a.course_id=c.id "
                + "GROUP by c.id";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            if (rs != null) {
                array = new ArrayList<Course>();
                while (rs.next()) {

                    obj = new Course();
                    obj.setId(rs.getInt(1));
                    obj.setName(rs.getString(2));
                    obj.setAssignment_count(rs.getInt(3));
                    array.add(obj);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CourseDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDBHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDBHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (array == null || array.isEmpty()) {
            return null;
        }
        return array;
    }
    
     public Course getCourseById(int id) {
        Course obj = null;
        String query = "SELECT c.* , count(a.course_id) FROM `courses` c "
                + "left join assignments a on a.course_id=c.id "
                + "GROUP by c.id "
                + " having id=?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(query);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs != null) {
                if (rs.next()) {

                    obj = new Course();
                    obj.setId(rs.getInt(1));
                    obj.setName(rs.getString(2));
                    obj.setAssignment_count(rs.getInt(3));
                    
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CourseDBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDBHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseDBHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return obj;
    }

}
