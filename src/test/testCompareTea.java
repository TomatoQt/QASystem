package test;

import Bean.*;
import utils.TimeConverter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class testCompareTea {
    public static void main(String []args){
        Calendar cal= Calendar.getInstance();
        Date date1=cal.getTime();
        cal.add(Calendar.DATE, 1);
        Date date2=cal.getTime();

        ReAskTeacher RKT=new ReAskTeacher();
        RKT.setrAskTea_time(TimeConverter.getDate_Str(date1));//today

        ReAnswerTeacher RAT=new ReAnswerTeacher();
        RAT.setrAnsTea_time(TimeConverter.getDate_Str(date2));//today+1

        System.out.println("date1: "+date1);
        System.out.println("date2: "+date2);

        ArrayList<CompareTea> list=new ArrayList<>();
        list.add(RAT);
        list.add(RKT);
        Collections.sort(list);

        System.out.println("after sorted");
        for (CompareTea item : list){
            if (item instanceof ReAskTeacher){
                System.out.println(((ReAskTeacher)item).getrAskTea_time());
            }else {
                System.out.println(((ReAnswerTeacher)item).getrAnsTea_time());
            }
        }
    }
}
