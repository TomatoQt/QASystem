package test;

import Bean.CompareStu;
import Bean.ReAnswerStudent;
import Bean.ReAskStudent;
import utils.TimeConverter;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class testCompareStu {
    public static void main(String []args){
        Calendar cal= Calendar.getInstance();
        Date date1=cal.getTime();
        cal.add(Calendar.DATE, 1);
        Date date2=cal.getTime();

        ReAskStudent RKS=new ReAskStudent();
        RKS.setrAskStu_time(TimeConverter.getDate_Str(date1));//today

        ReAnswerStudent RAS=new ReAnswerStudent();
        RAS.setrAnsStu_time(TimeConverter.getDate_Str(date2));//today+1

        System.out.println("date1: "+date1);
        System.out.println("date2: "+date2);

        ArrayList<CompareStu> list=new ArrayList<>();
        list.add(RAS);
        list.add(RKS);
        Collections.sort(list);

        System.out.println("after sorted");
        for (CompareStu item : list){
            if (item instanceof ReAskStudent){
                System.out.println(((ReAskStudent)item).getrAskStu_time());
            }else {
                System.out.println(((ReAnswerStudent)item).getrAnsStu_time());
            }
        }
    }
}
