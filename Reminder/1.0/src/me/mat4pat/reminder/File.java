package me.mat4pat.reminder;

import java.io.*;

public class File {

    /* Whenever new work is created or deleted,
    the file must be updated in order to add/delete work. */
    public static void updateWorkOnFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Work.txt"));

            int workOrder = 1;
            /* workOrder is used to print the work into the FILE as such:
             1. NOTES: ~~~~ ,DEADLINE: ~~~~~
             2. NOTES: ~~~~ ,DEADLINE: ~~~~~ */

            for (Work works : ExecuteReminder.works) {
                bw.write(workOrder + ". " + works.remind() + "\n");
                workOrder++;
            }
            bw.close();

        } catch(IOException e) {
            System.out.println("An error occurred while trying to open the file!");
        }
    }

    /* Simply reads the contents of the file and prints them on screen. */
    public static void returnWorkFromFile() {
        String text;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\Work.txt"));

            while ((text = br.readLine()) != null) {
                System.out.println(text);
            }
            br.close();

        } catch(IOException e) {
            System.out.println("An error occurred while trying to open the file!");
        }
    }

    /* After we exit, or terminate the program,
    the Garbage Collector deletes all the elements in the ArrayList 'works'.
    This function creates objects based on how many notes and deadlines exist in the file "Work.txt" -
    these objects are added to the ArrayList once again. */
    public static void addWorkToArrayList() {
        String text;
        String substringText;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\Work.txt"));

            while ((text= br.readLine())!=null) {
                substringText = text.substring(3);
                /* substringText is basically the whole line in a file except the number and dot.
                substringText is then set as the notesAndDeadlines at Work instance. */
                ExecuteReminder.works.add(new Work(substringText));
            }
            br.close();

        } catch(IOException e) {
            System.out.println("An error occurred while trying to open the file!");
        }
    }
}