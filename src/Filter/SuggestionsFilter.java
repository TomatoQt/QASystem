package Filter;

import Bean.*;
import Dao.stuAnswerDao;
import Dao.stuSugDao;
import Dao.teaAnsDao;
import Dao.teaSugDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "SuggestionsFilter", urlPatterns = {"/TeacherSuggestions.jsp","/StudentSuggestions.jsp","/CheckSuggestions.jsp"})
public class SuggestionsFilter extends HttpFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (((String)req.getSession().getAttribute("userType")).equals("student")){//student
            stuSugDao dao=new stuSugDao();
            ArrayList<StuSuggestion> stuSugs=dao.findByStu_id(((Student)req.getSession().getAttribute("user")).getId());
            req.setAttribute("stu_suggestions",stuSugs);
        }else if (((String)req.getSession().getAttribute("userType")).equals("teacher")){//teacher
            teaSugDao dao=new teaSugDao();
            ArrayList<teaSuggestion> teaSugs=dao.findByTea_id(((Teacher)req.getSession().getAttribute("user")).getId());
            req.setAttribute("tea_suggestions",teaSugs);
        }else {//admin
            stuSugDao studao=new stuSugDao();
            ArrayList<StuSuggestion> stuSugs=studao.findAll();
            req.setAttribute("stu_suggestions",stuSugs);
            teaSugDao teadao=new teaSugDao();
            ArrayList<teaSuggestion> teaSugs=teadao.findAll();
            req.setAttribute("tea_suggestions",teaSugs);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("SuggestionsFilter Initialized");
    }

}
