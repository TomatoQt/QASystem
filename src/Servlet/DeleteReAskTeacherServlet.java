package Servlet;

import Dao.ReAskTeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteReAskTeacherServlet")
public class DeleteReAskTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rAskTea_id=request.getParameter("rAskTea_id");
        ReAskTeacherDao dao=new ReAskTeacherDao();
        String message="";

        if (dao.deleteRAskTea(rAskTea_id)){
            message="delete re ask teacher succeed";
        }else {
            message="delete re ask teacher failed";
            System.out.println(message);
        }
        request.setAttribute("rAskTea_id",message);
        request.getRequestDispatcher("").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
