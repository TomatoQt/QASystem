package Servlet;

import Dao.NoticeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteNoticeServlet", urlPatterns = {"/deleteNotice.do"})
public class DeleteNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String notice_id=request.getParameter("notice_id");
        NoticeDao dao=new NoticeDao();
        String message="";
        if (dao.deleteNotice(notice_id)){
            message="delete notice succeed";
//            request.getRequestDispatcher("").forward(request,response);
            response.sendRedirect("CheckNotice.jsp");
        }else {
            message="delete notice failed";
        }
        System.out.println(message);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
