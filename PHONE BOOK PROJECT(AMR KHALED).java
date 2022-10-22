package com.company;
import java.io.*;
import java.util.*;
import java.io.IOException;
public class Main {
    //amr kHALED GABER
    //21100834
    public static void main(String[] args) throws IOException {
        displaymenu();
    }
    public static void callcontact(String name) {
        System.out.println("calling" + "\t" + name);
    }
    public static void savecontant(String First_name_person, String Second_name_person,
                                   int number_street, String address, String city, long number_phone) {
        System.out.println("saving contact.....");
        //==================================================================================================
        //file
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("PHONEBOOK.txt",true));
            pw.println(First_name_person + Second_name_person + ":" + number_street +","+address+
                    "," + city +","+ number_phone);
            pw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void findnumber() throws IOException {
        System.out.println("search contact .........");
        String word = ""; int val = 0;
        while(!word.matches("q"))
        {
            System.out.println("Enter the word to be searched for");
            Scanner input = new Scanner(System.in);
            word = input.next();
            Scanner file = new Scanner(new File("PHONEBOOK.txt"));

            while(file.hasNextLine())
            {
                String line = file.nextLine();
                if(line.indexOf(word) != -1)
                {
                    System.out.println("Word EXISTS in the file");
                    val = 1;
                    break;
                }
                else
                {
                    val = 0;
                    continue;
                }
            }
            if(val == 0)
            {
                System.out.println("Word does not exist");
            }
            System.out.println("-- enter continue or quit");
            word = input.next();
        }}
    public static void display_dictionary() {
        try {
            File NEW = new File("PHONEBOOK.txt");
            Scanner myReader = new Scanner(NEW);
            while (myReader.hasNextLine()) {
                String dataNAME = myReader.nextLine();
                System.out.println(dataNAME);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void delete_file() {
        File delete_file_1 = new File("PHONEBOOK.txt");
        if (delete_file_1.delete()) {
            System.out.println("Deleted the file: " + delete_file_1.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
    static void modifyFile() throws IOException {
        Scanner mod = new Scanner(System.in);
        String filePath = "PHONEBOOK.txt";
        Scanner sc = new Scanner(new File(filePath));
        StringBuilder buffer = new StringBuilder();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        System.out.println("Contents of the file: "+fileContents);
        sc.close();
        System.out.println("enter last name");
        String list_Name = mod.next();
        String oldLine = list_Name;
        String First_name_person="" ; String Second_name_person="" ;  int number_street = 0 ;
        String address = "";  String city=""  ; long number_phone=0;
        MODIFING_CHOICE(  First_name_person ,  Second_name_person ,   number_street,
                address ,   city    , number_phone        );
        String newLine = First_name_person + Second_name_person+number_street+city+number_phone;
        fileContents = fileContents.replaceAll(oldLine, newLine);
        FileWriter writer = new FileWriter(filePath);
        System.out.println("");
        System.out.println("new data: "+fileContents);
        writer.append(fileContents);
        writer.flush();
    }
    public static void MODIFING_CHOICE( String First_name_person , String Second_name_person ,  int number_street,
                                        String address ,  String city    ,long number_phone        ){
        Scanner input = new Scanner(System.in);
        System.out.println("What the first name  would you like to save");
        First_name_person = input.next();
        System.out.println("What the  last name would you like to save");
        Second_name_person = input.next();
        System.out.println("What the  address of the person");
        System.out.println("What the Number of street");
        number_street = input.nextInt();
        System.out.println("Enter  address");
        address = input.next();
        System.out.println("enter His or Her city ");
        city = input.next();
        System.out.println("what is the phone number of the person you ara saving ");
        number_phone = input.nextInt();
    }
    public static void information() {
        File test = new File("PHONEBOOK.txt");
        if (test.exists()) {
            System.out.println("File name: " + test.getName());
            System.out.println("Absolute path: " + test.getAbsolutePath());
            System.out.println("Writeable: " + test.canWrite());
            System.out.println("Readable " + test.canRead());
            System.out.println("File size in bytes " + test.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }
    public static void displaymenu() throws IOException {

        int i;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("<<<<<<<<<<WELCOME>>>>>>>>>>>");
            System.out.println("1-call contact");
            System.out.println("2-save a contact");
            System.out.println("3- find Number");
            System.out.println("4- View full phone book");
            System.out.println("5- DELETE  phone book");
            System.out.println("6 -info");
            System.out.println("7-modify contect");
            System.out.println("8-exit");
            int choice = input.nextInt();
            i = 0;
            switch (choice) {
                case 1:
                    System.out.println(" who would you like to call");
                    String name = input.next();
                    callcontact(name);
                    System.out.println("<<<done successfully>>>");
                    break;

                case 2:

                    System.out.println("What the first name  would you like to save");
                    String First_name_person = input.next();
                    System.out.println("What the  last name would you like to save");
                    String Second_name_person = input.next();
                    System.out.println("What the  address of the person");
                    System.out.println("What the Number of street");
                    int number_street = input.nextInt();
                    System.out.println("Enter  address");
                    String address = input.next();
                    System.out.println("enter His or Her city ");
                    String city = input.next();
                    System.out.println("what is the phone number of the person you ara saving ");
                    long number_phone = input.nextInt();
                    savecontant(First_name_person, Second_name_person,
                            number_street, address, city, number_phone);
                    System.out.println("<<<done successfully>>>");
                    break;

                case 3:
                    System.out.println("what is the name of the person would you want to searching");
                    findnumber();
                    System.out.println("<<<done successfully>>>");
                    break;

                case 4:
                    display_dictionary();
                    System.out.println("<<<done successfully>>>");
                    break;

                case 5:
                    delete_file();
                    System.out.println("<<<done successfully>>>");
                    break;
                case 6:
                    information();
                    System.out.println("<<<done successfully>>>");
                    break;
                case 7:

                    modifyFile( );
                    break;
                case 8:
                    i = 8;
                    break;
            }
        }
        while (i != 8);
        System.out.println("Have a nice day...");

    }
}

