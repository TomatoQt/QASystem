package Filter;

import Bean.Question;
import Dao.QuestionDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "QuestionPageFilter")
public class QuestionPageFilter extends HttpFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String url=req.getRequestURI();
        if (url.endsWith("QuestionPage.jsp")){
            QuestionDao questionDao=new QuestionDao();
            ArrayList<Question> questions=questionDao.findAllQuestion();
            req.setAttribute("questions",questions);
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("QuestionPage Filter Initiated.");
    }
}
