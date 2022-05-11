package Entity;
import Service.PersonalInformationBusiness;

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


    public boolean isRequestConfirm() {
        return requestConfirm;
    }
}

