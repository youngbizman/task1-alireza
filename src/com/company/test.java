package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) throws ParseException {
     /*   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));*/
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Scanner keyboard = new Scanner(System.in);
        String i = keyboard.nextLine();
        String y = keyboard.nextLine();
        System.out.println(i);
       /* Date d1 = sdformat.parse(i);
        Date d2 = sdformat.parse(y);
        long dif = d2.getTime()-d1.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(dif, TimeUnit.MILLISECONDS);
        System.out.println(diffrence);*/

        }

    }
