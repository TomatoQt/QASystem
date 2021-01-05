package Servlet;

import Bean.ReAnswerStudent;
import Bean.ReAnswerTeacher;
import Dao.ReAnswerStudentDao;
import Dao.ReAnswerTeacherDao;
import utils.TimeConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AddReAnswerServlet", urlPatterns = {"/addReAns.do"})
public class AddReAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType=(String) request.getSession().getAttribute("userType");
        if (userType.equals("student")){//student
            ReAnswerStudentDao dao=new ReAnswerStudentDao();
            String rAnsStu_id="RAS"+ (dao.getBigId() + 1);
            String stuA_id=request.getParameter("Answer_id");
            String rAnsStu_content=request.getParameter("ReAnswer_content");
            Date rAnsStu_time=new Date();
            int rAnsStu_nice=0;
            int rAnsStu_tread=0;
            ReAnswerStudent rAnsStu=new ReAnswerStudent(rAnsStu_id,stuA_id,rAnsStu_content, TimeConverter.getDate_Str(rAnsStu_time),rAnsStu_nice,rAnsStu_tread);

            //获取当前回答问题的ID
            String question_id=(String)request.getSession().getAttribute("current_question_id");
            if (dao.addReAnsStu(rAnsStu)){
                response.sendRedirect("QuestionAnswer.jsp?Q_id="+question_id);//add re-answer student page
            }else {
                System.out.println("add re-answer student failed");
            }
        }else {//teacher
            String rAnsTea_id=request.getParameter("rAnsTea_id");
            String teaA_id=request.getParameter("teaA_id");
            String rAnsTea_content=request.getParameter("rAnsTea_content");
            Date rAnsTea_time=new Date();
            int rAnsTea_nice=0;
            int rAnsTea_tread=0;
            ReAnswerTeacher rAnsTea=new ReAnswerTeacher(rAnsTea_id,teaA_id,rAnsTea_content,TimeConverter.getDate_Str(rAnsTea_time),rAnsTea_nice,rAnsTea_tread);
            ReAnswerTeacherDao dao=new ReAnswerTeacherDao();
            if (dao.addReAnsTea(rAnsTea)){
                response.sendRedirect("");//add re-answer teacher page
            }else {
                System.out.println("add re-answer teacher failed");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
