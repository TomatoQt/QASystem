package Servlet;

import Bean.Teacher;
import Dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("teacher_id");
        String nickname=request.getParameter("nickname");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        Boolean sex=request.getParameter("sex").equals("1");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String idCard=request.getParameter("idCard");

        String message="";

        Teacher teacher=new Teacher(id,nickname,password,name,sex,phone,email,idCard);
        TeacherDao dao=new TeacherDao();
        if (dao.updateTeacher(teacher)){
            message="update teacher info succeed";
        }else {
            message="update teacher info failed";
            System.out.println(message);
        }

        request.setAttribute("teacher_info",message);
        request.getRequestDispatcher("").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
