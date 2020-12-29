package Servlet;

import Bean.QuestionType;
import Dao.questionTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddQuestionTypeServlet")
public class AddQuestionTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String qType_id=request.getParameter("qType_id");
        String qType_name=request.getParameter("qType_name");
        QuestionType questionType=new QuestionType(qType_id,qType_name);
        questionTypeDao dao=new questionTypeDao();
        if (dao.addQuestionType(questionType)){
            response.sendRedirect("");
        }else {
            System.out.println("add question type failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
