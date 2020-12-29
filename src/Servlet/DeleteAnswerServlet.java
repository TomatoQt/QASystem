package Servlet;

import Dao.stuAnswerDao;
import Dao.teaAnsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAnswerServlet")
public class DeleteAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType=(String)request.getSession().getAttribute("userType");
        String message_delete="";

        if (userType.equals("student")){
            String stuA_id=request.getParameter("stuA_id");
            stuAnswerDao dao=new stuAnswerDao();
            if (dao.deleteStuAnswer(stuA_id)){
                message_delete="delete student answer succeed";
                request.getRequestDispatcher("").forward(request,response);//delete student answer page
//                response.sendRedirect("");//delete student answer page
            }else {
                message_delete="delete student answer failed";
                System.out.println(message_delete);
            }
        }else {
            String teaA_id=request.getParameter("teaA_id");
            teaAnsDao dao=new teaAnsDao();
            if (dao.deleteTeaAns(teaA_id)){
                message_delete="delete teacher answer succeed";
                request.getRequestDispatcher("").forward(request,response);//delete teacher answer page
            }else {
                message_delete="delete teacher answer failed";
                System.out.println(message_delete);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
