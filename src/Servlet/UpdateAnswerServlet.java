package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "UpdateAnswerServlet")
public class UpdateAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType=(String) request.getSession().getAttribute("userType");

        if (userType.equals("student")){
            String stuA_id=request.getParameter("stuA_id");
            String q_id=request.getParameter("q_id");
            String stu_id=request.getParameter("stu_id");
            String stuA_content=request.getParameter("stuA_content");
//            int stuA_nice=request;
//            int stuA_tread;
//            Date stuA_time;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
