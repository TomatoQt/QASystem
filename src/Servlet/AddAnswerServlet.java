package Servlet;

import Bean.*;
import Dao.stuAnswerDao;
import Dao.teaAnsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddAnswerServlet", urlPatterns = {"/answer.do"})
public class AddAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType=(String)request.getSession().getAttribute("userType");

        if (userType.equals("student")){
            stuAnswerDao dao=new stuAnswerDao();
            String stuA_id=Integer.toString(dao.getBigId()+1);
            String q_id=((Question)request.getAttribute("question")).getId();
            String stu_id=((Student)request.getSession().getAttribute("user")).getId();
            String stuA_content=request.getParameter("stuA_content");
            int stuA_nice=0;
            int stuA_tread=0;
            Date stuA_time=new Date(System.currentTimeMillis());
            StuAnswer stuAnswer=new StuAnswer(stuA_id,q_id,stu_id,stuA_content,stuA_nice,stuA_tread,stuA_time);

            if (dao.addStuAnswer(stuAnswer)){
                request.getRequestDispatcher("QuestionAnswer.jsp").forward(request,response);//add student answer page
            }else {
                System.out.println("add student answer failed");
            }
        }else {//teacher answer
            teaAnsDao dao=new teaAnsDao();
            String teaA_id=Integer.toString(dao.getBigId()+1);
            String q_id=request.getParameter("q_id");
            String tea_id=((Teacher)request.getSession().getAttribute("user")).getId();
            String teaA_content=request.getParameter("teaA_content");
            int teaA_nice=0;
            int teaA_tread=0;
            Date teaA_time=new Date(System.currentTimeMillis());
            teaAnswer tA=new teaAnswer(teaA_id,q_id,tea_id,teaA_content,teaA_nice,teaA_tread,teaA_time);

            if (dao.addTeaAns(tA)){
                request.getRequestDispatcher("QuestionAnswer.jsp").forward(request,response);//add teacher answer page
            }else {
                System.out.println("add teacher answer failed");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
