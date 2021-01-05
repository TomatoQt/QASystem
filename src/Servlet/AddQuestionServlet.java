package Servlet;

import Bean.Question;
import Bean.Student;
import Dao.QuestionDao;
import utils.TimeConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AddQuestionServlet", urlPatterns = {"/addQuestion"})
public class AddQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao=new QuestionDao();
        String id="Q"+ (dao.getBigId()+1);
        String stu_id=((Student)request.getSession().getAttribute("user")).getId();
        String title=request.getParameter("question_title");
        String content=request.getParameter("question_content");
        int click=0;//initial state
        Date time=new Date();

        Question question=new Question(id,stu_id,title,content,click, TimeConverter.getDate_Str(time));
        if (dao.addQuestion(question)){
            request.setAttribute("add_question_success","提问成功");
            request.getRequestDispatcher("newQuestion.jsp").forward(request,response);//add question page
        }else{
            System.out.println("add question failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
