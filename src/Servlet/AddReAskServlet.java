package Servlet;

import Bean.ReAskStudent;
import Bean.ReAskTeacher;
import Dao.ReAskStudentDao;
import Dao.ReAskTeacherDao;
import utils.TimeConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AddReAskServlet")
public class AddReAskServlet extends HttpServlet {
    //逻辑有问题，这里追问的对象不同，并不是追问的主体不同，用session作用域变量是无法区分的
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType=(String) request.getSession().getAttribute("userType");
        if (userType.equals("student")){//student
            String rAskStu_id=request.getParameter("rAskStu_id");
            String stuA_id=request.getParameter("stuA_id");
            String rAskStu_content=request.getParameter("rAskStu_content");
            Date rAskStu_time=new Date();
            ReAskStudent reAskStudent=new ReAskStudent(rAskStu_id,stuA_id,rAskStu_content, TimeConverter.getDate_Str(rAskStu_time));
            ReAskStudentDao dao=new ReAskStudentDao();
            if (dao.addRAskStu(reAskStudent)){
                response.sendRedirect("");//add reask student page
            }else {
                System.out.println("add reAsk student failed");
            }
        }else {//teacher
            String rAskTea_id=request.getParameter("rAskTea_id");
            String teaA_id=request.getParameter("teaA_id");
            String rAskTea_content=request.getParameter("rAskTea_content");
            Date rAskTea_time=new Date();
            ReAskTeacher reAskTeacher=new ReAskTeacher(rAskTea_id,teaA_id,rAskTea_content,TimeConverter.getDate_Str(rAskTea_time));
            ReAskTeacherDao dao=new ReAskTeacherDao();
            if (dao.addRAskTea(reAskTeacher)){
                response.sendRedirect("");//add reask teacher page
            }else {
                System.out.println("add reask teacher failed");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
