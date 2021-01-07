package Servlet;

import Bean.Admin;
import Bean.Notice;
import Dao.NoticeDao;
import utils.TimeConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AddNoticeServlet", urlPatterns = {"/addNotice.do"})
public class AddNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NoticeDao dao=new NoticeDao();

        String notice_id="N"+Integer.toString(dao.getBigId()+1);//request.getParameter("notice_id");
        String notice_title=request.getParameter("notice_title");
        String notice_content=request.getParameter("notice_content");
        Date nowTime=new Date();
        String adm_id=((Admin)request.getSession().getAttribute("user")).getId();
        Notice notice=new Notice(notice_id,notice_title,notice_content, TimeConverter.getDate_Str(nowTime),adm_id);

        if (dao.addNotice(notice)){
            response.sendRedirect("SendNotice.jsp");//add notice page
            System.out.println("add notice succeeded");
        }else {
            System.out.println("add notice failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
