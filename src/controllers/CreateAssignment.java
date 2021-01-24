package controllers;

import java.io.IOException;
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
 * Servlet implementation class CreateAssignment
 */
@WebServlet("/CreateAssignment")
public class CreateAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAssignment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void processGetRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseid_s = request.getParameter("courseid");
        int id = 0;
        id = Integer.parseInt(courseid_s);
        CourseDBHandler course_db = new CourseDBHandler();
        Course course = course_db.getCourseById(id);
        request.setAttribute("course", course);
        request.getRequestDispatcher("/WEB-INF/create_assignment.jsp").forward(request, response);

    }

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseid_s = request.getParameter("courseid");
        int id = 0;
        id = Integer.parseInt(courseid_s);

        String name = request.getParameter("name");
        Assignment dto = new Assignment();
        dto.setCourse_id(id);
        dto.setName(name);
        
        AssignmentDBHandler assignment_db = new AssignmentDBHandler();
        assignment_db.CreateAssignment(dto);
        String url = "DisplayAssignments?courseid=" + id;
        response.sendRedirect(url);
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
        processGetRequest(request, response);
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
        processPostRequest(request, response);
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
