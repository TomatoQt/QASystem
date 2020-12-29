package Servlet;

import Bean.StuAnswer;
import Bean.teaAnswer;
import Dao.stuAnswerDao;
import Dao.teaAnsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddAnswerServlet")
public class AddAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType=(String)request.getSession().getAttribute("userType");

        if (userType.equals("student")){
            String stuA_id=request.getParameter("stuA_id");
            String q_id=request.getParameter("q_id");
            String stu_id=request.getParameter("stu_id");
            String stuA_content=request.getParameter("stuA_content");
            int stuA_nice=0;
            int stuA_tread=0;
            Date stuA_time=new Date(System.currentTimeMillis());
            StuAnswer stuAnswer=new StuAnswer(stuA_id,q_id,stu_id,stuA_content,stuA_nice,stuA_tread,stuA_time);
            stuAnswerDao dao=new stuAnswerDao();
            if (dao.addStuAnswer(stuAnswer)){
                response.sendRedirect("");//add student answer page
            }else {
                System.out.println("add student answer failed");
            }
        }else {//teacher answer
            String teaA_id=request.getParameter("teaA_id");
            String q_id=request.getParameter("q_id");
            String tea_id=request.getParameter("tea_id");
            String teaA_content=request.getParameter("teaA_content");
            int teaA_nice=0;
            int teaA_tread=0;
            Date teaA_time=new Date(System.currentTimeMillis());
            teaAnswer tA=new teaAnswer(teaA_id,q_id,tea_id,teaA_content,teaA_nice,teaA_tread,teaA_time);

            teaAnsDao dao=new teaAnsDao();
            if (dao.addTeaAns(tA)){
                response.sendRedirect("");//add teacher answer page
            }else {
                System.out.println("add teacher answer failed");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
