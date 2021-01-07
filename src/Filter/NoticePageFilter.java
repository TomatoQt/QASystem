package Filter;

import Bean.*;
import Dao.NoticeDao;
import Dao.stuAnswerDao;
import Dao.teaAnsDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "NoticePageFilter", urlPatterns = {"/CheckNotice.jsp","/TeacherNotice.jsp","/StudentNotice.jsp"})
public class NoticePageFilter extends HttpFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        NoticeDao dao=new NoticeDao();
        ArrayList<Notice> notices=dao.findAllNotice();
        req.setAttribute("notices",notices);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
