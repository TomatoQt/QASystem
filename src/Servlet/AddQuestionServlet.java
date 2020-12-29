package Servlet;

import Bean.Question;
import Dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("question_id");
        String stu_id=request.getParameter("stu_id");
        String title=request.getParameter("question_title");
        String content=request.getParameter("question_content");
        int click=0;//initial state
        Date time=new Date(System.currentTimeMillis());

        Question question=new Question(id,stu_id,title,content,click,time);
        QuestionDao dao=new QuestionDao();
        if (dao.addQuestion(question)){
            response.sendRedirect("");//add question page
        }else{
            System.out.println("add question failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
