package Servlet;

import Dao.ReAskStudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteReAskStudentServlet")
public class DeleteReAskStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rAskStu_id=request.getParameter("rAskStu_id");
        String message="";
        ReAskStudentDao dao=new ReAskStudentDao();
        if (dao.deleteRAskStu(rAskStu_id)){
            message="delete re ask student succeed";
        }else {
            message="delete re ask student failed";
            System.out.println(message);
        }
        request.setAttribute("rAskStu_message",message);
        request.getRequestDispatcher("").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
