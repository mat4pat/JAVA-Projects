package me.mat4pat.reminder;

import java.util.Scanner;

public class Work {

    private String notesAndDeadline;

    // Constructor for creating objects through "Insert work" option.
    public Work() {
        setNotesAndDeadline();
    }

    // Constructor for creating objects through addWorkToArrayList().
    public Work(String notesAndDeadline) {
        this.notesAndDeadline=notesAndDeadline;
    }

    public String remind() {
        return notesAndDeadline;
    }

    private void setNotesAndDeadline() {
        Scanner notesInput = new Scanner(System.in);
        Scanner deadlineInput = new Scanner(System.in);

        System.out.print("Please enter the notes: ");
        String notes = notesInput.nextLine();
        System.out.print("Please enter the deadline: ");
        String deadline = deadlineInput.nextLine();

        String finalResult = "NOTES: " + notes + " ,DEADLINE: " + deadline;
        this.notesAndDeadline = finalResult;

        // The field notesAndDeadline of each object(or work for easier understanding) -
        // will be equal to finalResult.
    }
}
