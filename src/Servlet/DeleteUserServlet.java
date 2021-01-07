package Servlet;

import Dao.StudentDao;
import Dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteStudentServlet", urlPatterns = {"/deleteUser.do"})
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("type");

        if (type.equals("student")){
            StudentDao dao=new StudentDao();
            String studentId=request.getParameter("delete_user_id");
            if (dao.deleteStudent(studentId)){
                response.sendRedirect("deleteUser.jsp");//delete page
            }else {
                System.out.println("delete student failed");
            }
        }else {//teacher
            TeacherDao dao=new TeacherDao();
            String teacherId=request.getParameter("delete_user_id");
            if (dao.deleteTeacher(teacherId)){
                response.sendRedirect("deleteUser.jsp");//delete teacher page
            }else {
                System.out.println("delete teacher failed");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
