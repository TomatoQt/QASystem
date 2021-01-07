package Servlet;

import Bean.StuSuggestion;
import Bean.Student;
import Bean.Teacher;
import Bean.teaSuggestion;
import Dao.stuSugDao;
import Dao.teaSugDao;
import utils.TimeConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AddSuggestionServlet", urlPatterns = {"/addSuggestion.do"})
public class AddSuggestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType=(String)request.getSession().getAttribute("userType");

        if (userType.equals("student")){
            stuSugDao dao=new stuSugDao();
            String stuS_id="SS"+Integer.toString(dao.getBigId()+1);
            String stu_id=((Student)request.getSession().getAttribute("user")).getId();
            String stuS_title=request.getParameter("stuS_title");
            String stuS_content=request.getParameter("stuS_content");
            Date currentTime=new Date();

            StuSuggestion stuSuggestion=new StuSuggestion(stuS_id,stu_id,stuS_title,stuS_content, TimeConverter.getDate_Str(currentTime));

            if (dao.addStuSug(stuSuggestion)){
                response.sendRedirect("StudentOfferSuggestion.jsp");//add stu suggestion page
            }else {
                System.out.println("add student suggestion failed");
            }
        }else {
            teaSugDao dao=new teaSugDao();
            String teaS_id="TS"+Integer.toString(dao.getBigId()+1);//request.getParameter("teaS_id");
            String tea_id=((Teacher)request.getSession().getAttribute("user")).getId();
            String teaS_title=request.getParameter("teaS_title");
            String teaS_content=request.getParameter("teaS_content");
            Date teaS_time=new Date();

            teaSuggestion teaSug=new teaSuggestion(teaS_id,tea_id,teaS_title,teaS_content,TimeConverter.getDate_Str(teaS_time));

            if (dao.addTeaSug(teaSug)){
                response.sendRedirect("TeacherOfferSuggestion.jsp");//add teacher suggestion page
            }else {
                System.out.println("add teacher suggestion failed");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
