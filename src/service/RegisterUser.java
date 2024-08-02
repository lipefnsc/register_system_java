package service;

import domain.User;
import run.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterUser {

    String usersDirPath = "S:\\dev\\ws\\ws-java\\register_system\\users";

    private void readAndPrint() {
        File file = new File("form.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getUserInfoAndCreateFile() throws IOException {
        readAndPrint();
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        if (name.length() < 10) {
            throw new IOException("The name entered must be at least 10 characters long.");
        }
        String email = input.nextLine();
        if (!email.contains("@")) {
            throw new IOException("The email address provided must have \"@\"");
        }
        if (thereAreMatchingEmails().contains(email)) {
            throw new IOException("There is already a user registered with the email address entered.");
        }
        int age = input.nextInt();
        if (age < 18) {
            throw new IOException("It is not possible to register a user under the age of 18.");
        }
        input.nextLine();
        String height = input.nextLine();
        if (!height.contains(",")) {
            throw new IOException("The height must be entered in this pattern: \"1,80\"");
        }
        User user = new User(name, email, age, height);
        System.out.println(user + "\n");
        user.createUserFile();
        Main.mainMenu();
    }

    private List<String> thereAreMatchingEmails() throws IOException {
        File usersDir = new File(usersDirPath);
        File[] files = usersDir.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No users registered.");
            throw new IOException();
        }

        List<String> emails = new ArrayList<>();

        for (File file : files) {
            String email = extractEmailFromFile(file);
            emails.add(email);
        }

        return emails;

    }

    private String extractEmailFromFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        String email = br.readLine();
        return email;
    }

}
