package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AssignmentDBHandler;
import database.CourseDBHandler;
import models.Assignment;
import models.Course;

/**
 * Servlet implementation class DisplayAssignments
 */
@WebServlet("/DisplayAssignments")
public class DisplayAssignments extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String courseid_s = request.getParameter("courseid");
        int id = 0;
        id = Integer.parseInt(courseid_s);
        CourseDBHandler course_db = new CourseDBHandler();
        Course course = course_db.getCourseById(id);
        
        AssignmentDBHandler assignment_db= new AssignmentDBHandler();
        ArrayList<Assignment> assignmentList = assignment_db.getAllAssigmnetsByCourseId(id);
        
        
        request.setAttribute("assignmentList", assignmentList);
        request.setAttribute("course", course);
        request.getRequestDispatcher("/WEB-INF/display_assignments.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
