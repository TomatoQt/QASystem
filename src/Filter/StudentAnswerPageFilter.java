package Filter;

import Bean.*;
import Dao.stuAnswerDao;
import Dao.teaAnsDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "StudentAnswerPageFilter", urlPatterns = {"/StudentAnswers.jsp","/TeacherAnswers.jsp"})
public class StudentAnswerPageFilter extends HttpFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (((String)req.getSession().getAttribute("userType")).equals("student")){//student
            stuAnswerDao dao=new stuAnswerDao();
            ArrayList<StuAnswer> stuAnswers=dao.findByStuId(((Student)req.getSession().getAttribute("user")).getId());
            req.setAttribute("answers",stuAnswers);
        }else {//teacher
            teaAnsDao dao=new teaAnsDao();
            ArrayList<teaAnswer> teaAnswers=dao.findByTeaId(((Teacher)req.getSession().getAttribute("user")).getId());
            req.setAttribute("answers",teaAnswers);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("StudentAnswerPage Filter Initiated.");
    }

}
