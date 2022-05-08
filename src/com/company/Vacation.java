package com.company;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.util.Date;


public class Vacation {
   private String endingDate;
   private String beginningDate;
   PersonalInformation personalInformation;
    SimpleDateFormat vFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date i;
    Date y;
    long dif;
    long difference;
    boolean requestConfirm;

    public void setRequestConfirm(boolean requestConfirm) {
        this.requestConfirm = requestConfirm;
    }

    public Vacation(String beginningDate, String endingDate,PersonalInformation personalInformation) throws ParseException {
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.personalInformation = personalInformation;
        i = vFormat.parse(beginningDate) ;
        y = vFormat.parse(endingDate) ;
         dif = y.getTime()-i.getTime();
        TimeUnit time = TimeUnit.DAYS;
         difference = time.convert(dif, TimeUnit.MILLISECONDS);
         vacations.add(this);

    }
    public static List<Vacation> vacations = new ArrayList();

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public Vacation() throws ParseException {
    }

    public String getBeginningDate() {
        return beginningDate;
    }

    public String getEndingDate() {
        return endingDate;
    }



    public long getDifference() {
        return difference;
    }


    public static Vacation getVacationByName(String q) {
        int i;

        for (i = 0; i < Vacation.vacations.size(); i++) {
            if (Vacation.vacations.get(i).personalInformation.getName().equals(q))
            {
                return vacations.get(i);
            }
        }



        return null;
    }
    public static void printAllVacations() throws InterruptedException {
        int i ;
       for ( i = 0 ; i <vacations.size(); i++)
       {
           System.out.println(vacations.get(i).getPersonalInformation().getName()+"'s vacation");
           System.out.println("starting from "+vacations.get(i).getBeginningDate());
           System.out.println("until "+vacations.get(i).getEndingDate());
           if (vacations.get(i).requestConfirm == true) {
               System.out.println("state : confirmed");
           }
           else System.out.println("state : not confirmed\n");
           }
        Thread.sleep(2000);

    }
    public static void printConfirmedVacations() throws InterruptedException {

        int i ;
        for ( i = 0 ; i <vacations.size(); i++)
        {
            if (vacations.get(i).requestConfirm == true)
        {
            System.out.println(vacations.get(i).getPersonalInformation().getName()+"'s vacation");
            System.out.println("starting from "+vacations.get(i).getBeginningDate());
            System.out.println("until "+vacations.get(i).getEndingDate());
            Thread.sleep(2000);
        }
        }
    }
    public static void printUnconfirmedVacations() throws InterruptedException {

        int i ;
        for ( i = 0 ; i <vacations.size(); i++)
        {
            if (vacations.get(i).requestConfirm == false)
            {
                System.out.println(vacations.get(i).getPersonalInformation().getName()+"'s vacation");
                System.out.println("starting from "+vacations.get(i).getBeginningDate());
                System.out.println("until "+vacations.get(i).getEndingDate());
                Thread.sleep(2000);

            }
        }
    }
   public static void changeConfirmedVacation() {
       Scanner keyboard = new Scanner(System.in);
       System.out.println("Whose vacation do you wanna confirmed?");
       String name;
       name = keyboard.nextLine();
       Vacation.getVacationByName(name).setRequestConfirm(true);
       System.out.println(PersonalInformation.getPersonByName(name).getName() + "'s vacation has been successfully  confirmed");
   }
    public static void changeUnconfirmedVacation() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Whose vacation do you wanna unconfirmed?");
        String name;
        name = keyboard.nextLine();
        Vacation.getVacationByName(name).setRequestConfirm(false);
        System.out.println(PersonalInformation.getPersonByName(name).getName()+ "'s vacation has been successfully  unconfirmed");
    }


}

