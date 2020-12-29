package Servlet;

import Bean.StuSuggestion;
import Bean.teaSuggestion;
import Dao.stuSugDao;
import Dao.teaSugDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddSuggestionServlet")
public class AddSuggestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType=(String)request.getSession().getAttribute("userType");

        if (userType.equals("student")){
            String stuS_id=request.getParameter("stuSug_id");
            String stu_id=request.getParameter("stu_id");
            String stuS_title=request.getParameter("stuS_title");
            String stuS_content=request.getParameter("stuS_content");
            Date currentTime=new Date(System.currentTimeMillis());

            StuSuggestion stuSuggestion=new StuSuggestion(stuS_id,stu_id,stuS_title,stuS_content,currentTime);
            stuSugDao dao=new stuSugDao();
            if (dao.addStuSug(stuSuggestion)){
                response.sendRedirect("");//add stu suggestion page
            }else {
                System.out.println("add student suggestion failed");
            }
        }else {
            String teaS_id=request.getParameter("teaS_id");
            String tea_id=request.getParameter("tea_id");
            String teaS_title=request.getParameter("teaS_title");
            String teaS_content=request.getParameter("teaS_content");
            Date teaS_time=new Date(System.currentTimeMillis());

            teaSuggestion teaSug=new teaSuggestion(teaS_id,tea_id,teaS_title,teaS_content,teaS_time);
            teaSugDao dao=new teaSugDao();
            if (dao.addTeaSug(teaSug)){
                response.sendRedirect("");//add teacher suggestion page
            }else {
                System.out.println("add teacher suggestion failed");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
