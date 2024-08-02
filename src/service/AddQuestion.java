package service;

import run.Main;

import java.io.*;
import java.util.Scanner;

public class AddQuestion {

    String formPath = "S:\\dev\\ws\\ws-java\\register_system\\form.txt";

    public void add() throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(formPath, true));

        Scanner input = new Scanner(System.in);
        System.out.println("Type the new question: ");
        String newQuestion = input.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(formPath));
        String line;
        int counter = 0;

        while ((line = br.readLine()) != null) {
            counter += 1;
        }

        bw.newLine();
        bw.write((counter + 1) + " - " + newQuestion);
        bw.flush();

        Main.mainMenu();

    }
}
