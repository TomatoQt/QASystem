package Servlet;

import Bean.Admin;
import Bean.Student;
import Dao.AdminDao;
import Dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateAdminServlet", urlPatterns = {"/updateAdm.do"})
public class UpdateAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=((Admin)request.getSession().getAttribute("user")).getId();
        String nickname=request.getParameter("nickname");
        String password=((Admin)request.getSession().getAttribute("user")).getPassword();
        String name=request.getParameter("xing")+request.getParameter("ming");
        String phone=request.getParameter("phone");
        Boolean sex=request.getParameter("sex").equals("1");

        String message="";

        Admin admin=new Admin(id,nickname,password,name,sex,phone);
        AdminDao dao=new AdminDao();
        if (dao.updateAdmin(admin)){
            message="update student info succeed";
        }else {
            message="update student info failed";
        }
        System.out.println(message);
//        request.setAttribute("student_update",message);
//        request.getRequestDispatcher("").forward(request,response);
        request.getSession().setAttribute("user",dao.findById(id));//更新session中的user
        response.sendRedirect("AdminPage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
