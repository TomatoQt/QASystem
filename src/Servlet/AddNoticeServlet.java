package Servlet;

import Bean.Admin;
import Bean.Notice;
import Dao.NoticeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddNoticeServlet")
public class AddNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String notice_id=request.getParameter("notice_id");
        String notice_title=request.getParameter("notice_title");
        String notice_content=request.getParameter("notice_content");
        Date nowTime=new Date(System.currentTimeMillis());
        String adm_id=((Admin)request.getSession().getAttribute("user")).getId();
        Notice notice=new Notice(notice_id,notice_title,notice_content,nowTime,adm_id);
        NoticeDao dao=new NoticeDao();
        if (dao.addNotice(notice)){
            response.sendRedirect("");//add notice page
        }else {
            System.out.println("add notice failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
