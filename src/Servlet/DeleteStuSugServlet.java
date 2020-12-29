package Servlet;

import Dao.stuSugDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteStuSugServlet")
public class DeleteStuSugServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuS_id=request.getParameter("stuS_id");
        stuSugDao dao=new stuSugDao();
        if (dao.deleteStuSug(stuS_id)){
            response.sendRedirect("");//delete student suggestion page
        }else {
            System.out.println("delete student suggestion failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
