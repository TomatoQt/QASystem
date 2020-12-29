package Servlet;

import Dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteQuestionServlet")
public class DeleteQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String question_id=request.getParameter("question_id");
        QuestionDao dao=new QuestionDao();
        String message="";
        if (dao.deleteQuestion(question_id)){
            message="delete question succeed";
            request.getRequestDispatcher("").forward(request,response);
        }else {
            message="delete question failed";
            System.out.println(message);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
