package Entity;

import Service.PersonalInformationBusiness;
import Service.VacationBusiness;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.*;


enum MenuOptions
{
    a("Create personal"), b("Create Search"), c("Vacation Request"), d("Vacation Confirm"),
    e("Display Information"), q("quit"), z("Continue");

    // field
    private String meaning;

    // constructor
    MenuOptions(String meaning)
    {
        this.meaning = meaning;
    }

    // getters
    public String getMeaning()
    {
        return meaning;
    }
}
public class Main {
    int Phone;

    public static void main(String[] args) throws ParseException, InterruptedException {

        Scanner keyboard = new Scanner(System.in);
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");


        ArrayList<PersonalInformation> names = new ArrayList<PersonalInformation>();

        MenuOptions menuOptions = MenuOptions.z;


        while (true) {
            menu();


            menuOptions = MenuOptions.valueOf(keyboard.nextLine());


            switch (menuOptions) {
                case a:
                    personal();
                    break;

                case b:
                    search();
                    break;

                case c:
                    vacationRequest();
                    break;

                case d:
                    vacationConfirm();
                    break;

                case e:
                    break;

                case q:
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Selection out of range. Try again");
            }
        }


    }

    public static void menu() {
        System.out.println("\nEnter:");
        System.out.println("\ta. Create personal");
        System.out.println("\tb. Search");
        System.out.println("\tc. Vacation Request");
        System.out.println("\td. Vacation Confirm");
      //  System.out.println("\te. Display Banks, Branches, Customers, and Transactions.");
        System.out.println("\tq. Quit Application.");
        System.out.print("\nSelection -> ");

    }

    public static void personal() throws InterruptedException {
        String Name;
        String Address;
        int Age;
        int nationalCode;
        int Confirm;

        Scanner keyboard = new Scanner(System.in);
        System.out.print("What is your name?\n");
        Name = keyboard.nextLine();

        System.out.print("What is your full address?\n");
        Address = keyboard.nextLine();

        System.out.print("how old are you ?\n");
        Age = Integer.parseInt(keyboard.nextLine());

        System.out.print("Type your  national code without 0 in the beginning:\n");
        nationalCode = Integer.parseInt(keyboard.nextLine());

        PersonalInformation ali = new PersonalInformation(Name, Address, Age, nationalCode);
        for (int i = 1; i <= 1; i++) {
            System.out.println("Your name is " + ali.getName());
            System.out.println("Your address is " + ali.getAddress());
            System.out.println("Your age is " + ali.getAge());
            System.out.println("Your national code " + ali.getNationalCode());
        }
        System.out.print("please confirm your information entering 1\n");
        Confirm = keyboard.nextInt();
        if (Confirm == 1) {
            System.out.println("personal creation successfully done\n");
            Thread.sleep(2000);
        }

    }

    public static void search() throws InterruptedException {
        int i;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a national code without a 0 in the beginning:");
        i = keyboard.nextInt();
        System.out.println(PersonalInformationBusiness.getPersonByNumber(i).getName());
        Thread.sleep(2000);


    }

    public static void vacationRequest() throws ParseException {
        Scanner keyboard = new Scanner(System.in);
        String name;
        String beginning;
        String ending;
        int confirm;
        System.out.println("please enter your name");
        name = keyboard.nextLine();
        System.out.println("" + PersonalInformationBusiness.getPersonByName(name).getName() + " you have been successfully logged in");
        System.out.println("please enter your Vacation's beginning time in yyyy-mm-dd format");
        beginning = keyboard.nextLine();
        System.out.println("please enter your Vacation's ending time in yyyy-mm-dd format");
        ending = keyboard.nextLine();
        Vacation vacation = new Vacation(beginning, ending, PersonalInformationBusiness.getPersonByName(name));
        System.out.println("you want a " + vacation.getDifference() + " days vacation from "
                + vacation.getBeginningDate() + " until " + vacation.getEndingDate() + "\n" + " confirm entering 1 ");
        confirm = keyboard.nextInt();
        if (confirm == 1) {
            System.out.println(" your vacation request has been  successfully sent");
        }

    }

    public static void vacationConfirm() throws ParseException, InterruptedException {
        Scanner keyboard = new Scanner(System.in);
        String name;
        int i = 0;

        System.out.println("enter:\n a.  all vacations\n b.  confirmed vacations\n c.  unconfirmed vacations\n");
        String key = keyboard.nextLine();

        if (key.equalsIgnoreCase("a")) {
            VacationBusiness.printAllVacations();
        }
        if (key.equalsIgnoreCase("b")) {
            VacationBusiness.printConfirmedVacations();
            System.out.println("access editing clicking 1 ");
            i = keyboard.nextInt();
        if (i == 1) VacationBusiness.changeUnconfirmedVacation();

        }
         if (key.equalsIgnoreCase("c")) {
             VacationBusiness.printUnconfirmedVacations();
             System.out.println("access editing clicking 1 ");
             i = keyboard.nextInt();
             if (i == 1) {
                 VacationBusiness.changeConfirmedVacation();
             }
         }

            else vacationConfirm();


        }

    }

