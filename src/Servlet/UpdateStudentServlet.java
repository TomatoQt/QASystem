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

@WebServlet(name = "UpdateStudentServlet",urlPatterns = {"/updateStu.do"})
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=((Student)request.getSession().getAttribute("user")).getId();
        String nickname=request.getParameter("nickname");
        String password=((Student)request.getSession().getAttribute("user")).getPassword();
        String name=request.getParameter("xing")+request.getParameter("ming");
        String phone=request.getParameter("phone");
        Boolean sex=request.getParameter("sex").equals("1");
        String email=request.getParameter("email");
        String idCard=request.getParameter("idCard");

        String message="";

        Student student=new Student(id,nickname,password,name,phone,sex,email,idCard);
        StudentDao dao=new StudentDao();
        if (dao.updateStudentBasicInfo(student)){
            message="update student info succeed";
        }else {
            message="update student info failed";
        }
        System.out.println(message);
//        request.setAttribute("student_update",message);
//        request.getRequestDispatcher("").forward(request,response);
        request.getSession().setAttribute("user",dao.findById(id));//更新session中的user
        response.sendRedirect("StudentPage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
