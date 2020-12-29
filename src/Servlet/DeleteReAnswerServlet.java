package Servlet;

import Dao.ReAnswerStudentDao;
import Dao.ReAnswerTeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteReAnswerServlet")
public class DeleteReAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType=(String) request.getSession().getAttribute("userType");
        String message="";

        if (userType.equals("student")){
            String rAnsStu_id=request.getParameter("rAnsStu_id");
            ReAnswerStudentDao dao=new ReAnswerStudentDao();
            if (dao.deleteReAnsStu(rAnsStu_id)){
                message="delete re answer student succeed";
            }else {
                message="delete re answer student failed";
                System.out.println(message);
            }
            request.setAttribute("ReAns_message",message);
            request.getRequestDispatcher("").forward(request,response);
        }else {
            String rAnsTea_id=request.getParameter("rAnsTea_id");
            ReAnswerTeacherDao dao=new ReAnswerTeacherDao();
            if (dao.deleteReAnsTea(rAnsTea_id)){
                message="delete re answer teacher succeed";
            }else {
                message="delete re answer teacher failed";
                System.out.println(message);
            }
            request.getRequestDispatcher("").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
