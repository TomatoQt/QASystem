package Servlet;

import Bean.Admin;
import Bean.Student;
import Bean.Teacher;
import Dao.AdminDao;
import Dao.StudentDao;
import Dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/userLogin"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String userType=request.getParameter("userType");

        String login_message = "";

        if(userType.equalsIgnoreCase("student")){//学生登录
            StudentDao dao=new StudentDao();
            if(dao.login(username, password)){//准备跳转
                Student student=dao.findById(username);
                request.getSession().setAttribute("user",student);
                request.getSession().setAttribute("userType","student");
                login_message="学生登录成功";
                response.sendRedirect("studentPage.jsp");//跳转到登录过后的主页
            }else {//账号不存在或密码错误
                login_message="账号不存在或密码错误";
                System.out.println("账号不存在或密码错误");
                response.sendRedirect("login.jsp");
            }
        }else if(userType.equalsIgnoreCase("teacher")){//教师登录
            TeacherDao dao=new TeacherDao();
            if(dao.login(username,password)){
                Teacher teacher=dao.findById(username);
                request.getSession().setAttribute("user",teacher);
                request.getSession().setAttribute("userType","teacher");
                login_message="教师登录成功";
                response.sendRedirect("teacherPage.jsp");
            }else {
                login_message="账号不存在或密码错误";
                System.out.println("账号不存在或密码错误");
                response.sendRedirect("login.jsp");
            }
        }else {//管理员登录
            AdminDao dao=new AdminDao();
            if (dao.login(username,password)){
                Admin admin=dao.findById(username);
                request.getSession().setAttribute("user",admin);
                request.getSession().setAttribute("userType","admin");
                login_message="管理员登录成功";
                response.sendRedirect("adminPage.jsp");
            }else {
                login_message="账号不存在或密码错误";
                System.out.println("账号不存在或密码错误");
                response.sendRedirect("login.jsp");
            }
        }
        System.out.println(login_message);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
