package Servlet;

import Dao.questionTypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteQuestionTypeServlet")
public class DeleteQuestionTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionType_id=request.getParameter("questionType_id");
        String message="";
        questionTypeDao dao=new questionTypeDao();
        if (dao.deleteQuestionType(questionType_id)){
            message="delete question type succeed";
            request.getRequestDispatcher("").forward(request,response);
        }else {
            message="delete question type failed";
            System.out.println(message);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
