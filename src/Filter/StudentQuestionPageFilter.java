package Filter;

import Bean.Question;
import Bean.Student;
import Dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "StudentQuestionPageFilter", urlPatterns = {"/StudentQuestions.jsp"})
public class StudentQuestionPageFilter extends HttpFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        QuestionDao questionDao=new QuestionDao();
        ArrayList<Question> questions=questionDao.findQuestionByStu(((Student)req.getSession().getAttribute("user")).getId());
        req.setAttribute("questions",questions);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("StudentQuestionsPage Filter Initiated.");
    }

}
