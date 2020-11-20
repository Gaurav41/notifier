/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Gaurav
 */
public class Days {
    

public static void main(String args[])
{       
    SimpleDateFormat dfFromat=new SimpleDateFormat("yyyy-MM-dd");
    Date currDate=new Date();
    String dateStart =(dfFromat.format(currDate));
    String dateStop ="2020-10-30";
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    Date d1 = null;
    Date d2 = null;
    try {
        d1 = format.parse(dateStart);
        d2 = format.parse(dateStop);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    long diff = d2.getDate() - d1.getDate();
    long difference = d2.getTime() - d1.getTime();
    float daysBetween = (difference / (1000*60*60*24));
    System.out.println("diff: "+daysBetween);
    

}
}