package me.mat4pat.reminder;

import java.util.ArrayList;
import java.util.Scanner;

public class ExecuteReminder {

    static ArrayList<Work> works = new ArrayList<>();

    private static void createWork() {
        works.add(new Work());
        File.updateWorkOnFile();
        /*  Only creating an object without any reference because:
         *  It's impossible to put a name for the object's variable through terminal input.
         *  Thus, I will just be creating an object - and no name will be given to the object. */
    }

    private static void returnWork() {
        File.returnWorkFromFile();
    }

    private static void deleteWork(int indexOfWork) {
            works.remove(indexOfWork-1);
            File.updateWorkOnFile();
    }

    public static void main(String[] args) {
        /* See comment in File class for this method for further explanation. */
        File.addWorkToArrayList();

        boolean inputNotExit = true;

        while(inputNotExit) {
            printMenu();

            switch(askInput()) {
                case 1:
                    createWork();
                    break;
                case 2:
                    returnWork();
                    break;
                case 3:
                    System.out.print("Enter the number of the work in the order: ");
                    try {
                        deleteWork(askInput());
                    } catch(IndexOutOfBoundsException e) {
                        // If the number is an invalid number then automatically an exception is thrown.
                        System.out.println("You cannot delete work that doesn't exist!");
                    }
                    break;
                case 4:
                    inputNotExit=false;
                    break;
                default:
                    System.out.println("No such option!");
            }
        }
    }

    private static int askInput() {
        //  Instead of creating a variable of type scanner(for example: Scanner userInput),
        //  call the input method on the object directly, as oppose to calling the method on the variable reference.
        return new Scanner(System.in).nextInt();
    }

    private static void printMenu() {
        System.out.println("\n1. Insert work");
        System.out.println("2. View work");
        System.out.println("3. Delete work");
        System.out.println("4. Exit");
        System.out.print("Enter a number as a choice: ");
    }
}