package Servlet;

import Bean.Student;
import Dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("student_id");
        String nickname=request.getParameter("nickname");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String phone=request.getParameter("phone");
        Boolean sex=request.getParameter("sex").equals("1");
        String email=request.getParameter("email");
        String idCard=request.getParameter("idCard");

        String message="";

        Student student=new Student(id,nickname,password,name,phone,sex,email,idCard);
        StudentDao dao=new StudentDao();
        if (dao.updateStudent(student)){
            message="update student info succeed";
        }else {
            message="update student info failed";
            System.out.println(message);
        }
        request.setAttribute("student_update",message);
        request.getRequestDispatcher("").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
