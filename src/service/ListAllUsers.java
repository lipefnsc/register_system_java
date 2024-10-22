package service;

import run.Main;

import java.io.*;
import java.util.List;
import java.util.Objects;

public class ListAllUsers {

    String usersPath = "S:\\dev\\ws\\ws-java\\register_system\\users";

    public void listAllUsers() throws IOException {
        File usersDir = new File(usersPath);
        List<String> files = List.of(Objects.requireNonNull(usersDir.list()));

        if (files.isEmpty()) {
            System.out.println("There is no users registered.");
            return;
        }

        for (String filename : files) {
            File file = new File(usersDir, filename);
            String username = extractUserName(file);
            if (username != null) {
                System.out.println(username);
            }
        }

        System.out.println();
        Main.mainMenu();
    }

    private String extractUserName(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String firstLine = br.readLine();
            if (firstLine != null) {
                String fileName = file.getName();
                int dashIndex = fileName.indexOf('-');
                if (dashIndex > 0) {
                    String number = fileName.substring(0, dashIndex);
                    return number + " - " + firstLine;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}