package com.company;
import java.util.Scanner;

class library {
    String name = new String();
    private String[] avail_books = new String[50];
    private String[] issued_books = new String[50];
    private int chkbooks = 0;

    private int act;

    private void initial() {

        avail_books[0] = "AngelMaker";
        avail_books[1] = "Annabel";
        avail_books[2] = "Mathematics";
        avail_books[3] = "The Prisoner of Zenda";

    }

    private int tracking() {
        initial();
        int local = 0;
        while (avail_books[local] != null) {

            local++;
        }
        return local;
    }

    public void addBooks(String a) {
        avail_books[tracking()] = a;

    }

    public void showAvail() {
        System.out.print("---------------Available Books-----------------\n\n");
        for (int i = 0; i < tracking(); i++) {
            System.out.println(avail_books[i]);
        }
        System.out.println();
        System.out.print("-----------------------------------------------\n\n");


    }

    public void issueBook(String bkname) {
        int count = 0;
        if (chkbooks > 0) {
            for (int i = 0; i < chkbooks; i++) {
                for (int j = 0; j < chkbooks; j++) {
                    if (issued_books[i].equalsIgnoreCase(issued_books[j])) {
                        System.out.println("This book is already issued!!!");
                        System.out.println();
                        count++;
                    }
                }
            }
        }
        for (int i = 0; i < tracking(); i++) {
            if (bkname.equalsIgnoreCase(avail_books[i])) {
                issued_books[chkbooks] = avail_books[i];
                chkbooks++;
            }

        }
        if (chkbooks >= 1) {
            if (count == 0) {

                System.out.println("The issued books is :");
                for (int j = 0; j < chkbooks; j++) {
                    System.out.println(issued_books[j]);
                }
            }
        } else {
            System.out.println("There is no book with this name");
            System.out.println("No book is issued");
        }

    }

    public void returnBooks(String name) {
        int fix_no = chkbooks;
        if (chkbooks == 0) {
            System.out.println("There is no Book which you want to return");
        }
        for (int i = 0; i < chkbooks; i++) {
            if (name.equalsIgnoreCase(issued_books[i])) {
                System.out.println(issued_books[i] + " Book has been returned.");
                for (int j = i + 1; j < chkbooks; j++) {
                    issued_books[i] = issued_books[j];
                }
                chkbooks--;
            }
        }
        if (fix_no == chkbooks) {
            System.out.println("You have not returned the book");
        }
    }

}


public class Ex4_Online_Library {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String in1;
        String in2;
        String in3;
        int choice;
        String ans;
        library obj = new library();


        do {
            obj.showAvail();
            System.out.print("Press 1. To add book.\nPress 2. To issue book.\nPress 3. Return book\n\n");
            choice = input.nextInt();
            in1 = input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Book Name to add : ");
                    in1 = input.nextLine();
                    obj.addBooks(in1);
                    break;
                case 2:
                    System.out.println("Enter Book Name : ");
                    in2 = input.nextLine();
                    obj.issueBook(in2);
                    break;
                case 3:
                    System.out.println("Enter the name of the book to return : ");
                    in3 = input.nextLine();
                    obj.returnBooks(in3);
                    break;

            }
            System.out.println("Do you want to Continue.");
            System.out.println("(Y/N)");
            ans = input.nextLine();
        } while (!(ans.equalsIgnoreCase("N")));
    }
}