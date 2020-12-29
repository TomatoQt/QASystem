package Servlet;

import Bean.Student;
import Bean.Teacher;
import Dao.StudentDao;
import Dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/userRegister"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType=request.getParameter("userType");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String rpassword=request.getParameter("rpassword");
        Boolean sex = request.getParameter("sex").equals("1");

        String register_message="";

        if (userType.equalsIgnoreCase("student")){//学生注册
            StudentDao dao=new StudentDao();
            Student student=new Student();
            student.setId(username);
            student.setPassword(password);
            student.setSex(sex);
            if (password.equals(rpassword))
                if (dao.addStudent(student)){
                    register_message="学生注册成功";
                    response.sendRedirect("login.jsp");
                }else {
                    register_message="学生注册失败";
                    response.sendRedirect("register.jsp");
                }
            else
                register_message="学生注册失败";
        }else if(userType.equalsIgnoreCase("teacher")){//教师注册
            TeacherDao dao=new TeacherDao();
            Teacher teacher=new Teacher();
            teacher.setId(username);
            teacher.setPassword(password);
            teacher.setSex(sex);
            if (password.equals(rpassword))
                if (dao.addTeacher(teacher)){
                    register_message="教师注册成功";
                    response.sendRedirect("login.jsp");
                }else {
                    register_message="教师注册失败";
                    response.sendRedirect("register.jsp");
                }
            else
                register_message="教师注册失败";
        }
        System.out.println(register_message);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
