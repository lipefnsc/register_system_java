package service;

import domain.User;
import run.Main;

import java.io.*;
import java.util.*;

public class SearchUser {

    String usersDirPath = "S:\\dev\\ws\\ws-java\\register_system\\users";

    public void search() throws IOException {
        File usersDir = new File(usersDirPath);
        Scanner input = new Scanner(System.in);

        System.out.println("Type the name or part of the name of the user to search for: ");
        String searchInput = input.nextLine();

        List<File> files = List.of(Objects.requireNonNull(usersDir.listFiles()));

        if (files.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }

        List<User> users = new ArrayList<>();

        for (File file : files) {
            User user = extractUser(file);
            if (user != null && user.getName().toLowerCase().contains(searchInput.toLowerCase())) {
                users.add(user);
            }
        }

        users.sort(Comparator.comparing(User::getName));

        System.out.println("Users found: \n");

        if (users.isEmpty()) {
            System.out.println("There are no users registered with the given name.");
        } else {
            for (User user : users) {
                System.out.println(user + "\n");
            }

        }

        Main.mainMenu();

    }

    private User extractUser(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String name = br.readLine();
        String email = br.readLine();
        int age = Integer.parseInt(br.readLine());
        String height = br.readLine();

        if (name != null && email != null && age != 0 && height != null) {
            return new User(name, email, age, height);
        }
        
        return null;
    }
}