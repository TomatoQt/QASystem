package Servlet;

import Bean.Admin;
import Bean.stuSuggestionFeedback;
import Bean.teaSuggestionFeedback;
import Dao.stuSugFdDao;
import Dao.teaSugFdDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddSugFdServlet")
public class AddSugFdServlet extends HttpServlet {
    //有问题
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType=(String) request.getSession().getAttribute("userType");
        if (userType.equals("student")){
            String stuSugFd_id=request.getParameter("stuSugFd_id");
            String stuS_id=request.getParameter("stuS_id");
            String adm_id=((Admin)request.getSession().getAttribute("user")).getId();
            String stuSugFd_content=request.getParameter("stuSugFd_content");
            Date stuSugFd_time=new Date(System.currentTimeMillis());
            stuSuggestionFeedback fd=new stuSuggestionFeedback(stuSugFd_id,stuS_id,adm_id,stuSugFd_content,stuSugFd_time);
            stuSugFdDao dao=new stuSugFdDao();
            if (dao.addStuSugFd(fd)){
                response.sendRedirect("");//add student suggestion feedback page
            }else {
                System.out.println("add student suggestion feedback failed");
            }
        }else {
            String teaSugFd_id=request.getParameter("teaSugFd_id");
            String teaS_id=request.getParameter("teaS_id");
            String adm_id=((Admin)request.getSession().getAttribute("user")).getId();
            String teaSugFd_content=request.getParameter("teaSugFd_content");
            Date teaSugFd_time=new Date(System.currentTimeMillis());
            teaSuggestionFeedback fd=new teaSuggestionFeedback(teaSugFd_id,teaS_id,adm_id,teaSugFd_content,teaSugFd_time);
            teaSugFdDao dao=new teaSugFdDao();
            if (dao.addTeaSugFd(fd)){
                response.sendRedirect("");//add teacher suggestion feedback page
            }else {
                System.out.println("add teacher suggestion feedback failed");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
