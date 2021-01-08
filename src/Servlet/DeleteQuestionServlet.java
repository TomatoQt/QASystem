package Servlet;

import Dao.QuestionDao;
import Dao.stuAnswerDao;
import Dao.teaAnsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteQuestionServlet", urlPatterns = {"/deleteQuestion.do"})
public class DeleteQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String question_id=request.getParameter("Q_id");
        QuestionDao dao=new QuestionDao();
        stuAnswerDao sadao=new stuAnswerDao();
        teaAnsDao tadao=new teaAnsDao();
        String message="";

        if (sadao.deleteStuAnswerByQid(question_id)&&tadao.deleteTeaAnsByQid(question_id)&&dao.deleteQuestion(question_id)){
            message="delete question succeed";
//            request.getRequestDispatcher("").forward(request,response);
            response.sendRedirect("StudentQuestions.jsp");
        }else {
            message="delete question failed";
        }
        System.out.println(message);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
