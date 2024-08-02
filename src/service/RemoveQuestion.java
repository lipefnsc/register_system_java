package service;

import run.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveQuestion {

    String formPath = "S:\\dev\\ws\\ws-java\\register_system\\form.txt";

    public void remove() throws IOException {
        Scanner input = new Scanner(System.in);
        List<String> questions = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(formPath));
        String line;
        while ((line = br.readLine()) != null) {
            questions.add(line);
        }

        System.out.print("Type the number of the question you want to remove: ");
        int questionToRemove = input.nextInt();

        if (questionToRemove < 5 || questionToRemove > questions.size()) {
            System.out.println("Only questions from number five onwards can be deleted. Please try again.");
            return;
        }

        questions.remove(questionToRemove - 1);

        BufferedWriter bw = new BufferedWriter(new FileWriter(formPath));

        for (String question : questions) {
            bw.write(question);
            bw.flush();
            bw.newLine();
        }

        System.out.println("Question deleted. \n");

        Main.mainMenu();
    }
}
