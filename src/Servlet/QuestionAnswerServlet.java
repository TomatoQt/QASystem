package Servlet;

import Bean.Question;
import Bean.StuAnswer;
import Bean.teaAnswer;
import Dao.QuestionDao;
import Dao.stuAnswerDao;
import Dao.teaAnsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

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

        //教师问题回答
        teaAnsDao taDao=new teaAnsDao();
        ArrayList<teaAnswer> teaAnswers=taDao.findByQstnId(q_id);
        request.setAttribute("teacher_answers",teaAnswers);

        //学生问题回答
        stuAnswerDao saDao=new stuAnswerDao();
        ArrayList<StuAnswer> stuAnswers=saDao.findByQstnId(q_id);
        request.setAttribute("student_answers",stuAnswers);

        request.getRequestDispatcher("QuestionAnswer.jsp").forward(request,response);
    }
}
