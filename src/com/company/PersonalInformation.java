package com.company;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class PersonalInformation {
    private String name;
    private String address;
    private int age;
    private int nationalCode;

    PersonalInformation(String Name, String Address, int Age, int nationalCode) {
        name = Name;
        address = Address;
        age = Age;
        this.nationalCode = nationalCode;
        persons.add(this);

    }

    public static List<PersonalInformation> persons = new ArrayList();


    public String getName() {


        return name;
    }


    public String getAddress() {

        return address;

    }


    public int getAge() {


        return age;
    }


    public int getNationalCode() {

        return nationalCode;
    }

    public static PersonalInformation getPersonByNumber(int q) {
        int i;

        for (i = 0; i < PersonalInformation.persons.size(); i++) {
            if (PersonalInformation.persons.get(i).getNationalCode() == q)
            {
                return persons.get(i);
            }
        }
        return null;
    }

        public static PersonalInformation getPersonByName(String q) {
            int i;

            for (i = 0; i < PersonalInformation.persons.size(); i++) {
                if (PersonalInformation.persons.get(i).getName().equals(q))
                {
                    return persons.get(i);
                }
            }


        return null;
    }
}