package Servlet;

import Bean.*;
import Dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "QuestionAnswerServlet", urlPatterns = {"/QuestionAnswer.do"})
public class QuestionAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //问题
        String q_id=request.getParameter("Q_id");
        QuestionDao questionDao=new QuestionDao();
        Question question=questionDao.findById(q_id);
        request.setAttribute("question",question);

        //将当前问题ID存到session中，为后续的问题回答做准备
        request.getSession().setAttribute("current_question_id",q_id);

        //教师问题回答
        teaAnsDao taDao=new teaAnsDao();
        ArrayList<teaAnswer> teaAnswers=taDao.findByQstnId(q_id);
        request.setAttribute("teacher_answers",teaAnswers);

        ReAskTeacherDao RKTdao=new ReAskTeacherDao();
        ReAnswerTeacherDao RATdao=new ReAnswerTeacherDao();
        Map<String, ArrayList<CompareTea>> mapTeaA=new HashMap<String, ArrayList<CompareTea>>();
        for (teaAnswer ta : teaAnswers){
            ArrayList<ReAskTeacher> askList=RKTdao.findByTeaA_id(ta.getTeaA_id());
            ArrayList<ReAnswerTeacher> answerList=RATdao.findByTeaAnswerId(ta.getTeaA_id());

            ArrayList<CompareTea> compareList=new ArrayList<>(askList);
            compareList.addAll(answerList);

            Collections.sort(compareList);

            mapTeaA.put(ta.getTeaA_id(),compareList);
        }
        request.setAttribute("mapTeaA",mapTeaA);

        //学生问题回答
        stuAnswerDao saDao=new stuAnswerDao();
        ArrayList<StuAnswer> stuAnswers=saDao.findByQstnId(q_id);
        request.setAttribute("student_answers",stuAnswers);

        ReAskStudentDao RKSdao=new ReAskStudentDao();
        ReAnswerStudentDao RASdao=new ReAnswerStudentDao();
        Map<String, ArrayList<CompareStu>> mapStuA=new HashMap<String, ArrayList<CompareStu>>();
        for (StuAnswer stuAnswer : stuAnswers){
            ArrayList<ReAskStudent> askList=RKSdao.findByStuA_id(stuAnswer.getStuA_id());
            ArrayList<ReAnswerStudent> answerList=RASdao.findByStuAnsId(stuAnswer.getStuA_id());

            //将答案下的回复合并
            ArrayList<CompareStu> compareList = new ArrayList<>(askList);
            compareList.addAll(answerList);

            Collections.sort(compareList);

            mapStuA.put(stuAnswer.getStuA_id(),compareList);
        }
        request.setAttribute("mapStuA",mapStuA);

        //System.out.println(((ReAnswerStudent)mapStuA.get("SA2").get(0)).getrAnsStu_content());

        if (((String)request.getSession().getAttribute("userType")).equals("student")){
            request.getRequestDispatcher("QuestionAnswer.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("QA4Teacher.jsp").forward(request,response);
        }

    }
}
