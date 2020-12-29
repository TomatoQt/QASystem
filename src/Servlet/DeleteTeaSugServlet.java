package Servlet;

import Dao.teaSugDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteTeaSugServlet")
public class DeleteTeaSugServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teaS_id=request.getParameter("teaS_id");
        teaSugDao dao=new teaSugDao();
        if (dao.deleteTeaSug(teaS_id)){
            response.sendRedirect("");//delete teacher suggestion page
        }else {
            System.out.println("delete teacher suggestion failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
