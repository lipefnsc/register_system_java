package run;

import service.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        mainMenu();
    }

    public static void mainMenu() throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("""
                1 - Register a user
                2 - List all registered users
                3 - Add a new question to the form
                4 - Delete question from form
                5 - Search user by name
                6 - Quit""");

        int option = input.nextInt();

        switch (option) {
            case 1: {
                new RegisterUser().getUserInfoAndCreateFile();
                break;
            }
            case 2: {
                new ListAllUsers().listAllUsers();
                break;
            }
            case 3: {
                new AddQuestion().add();
                break;
            }
            case 4: {
                new RemoveQuestion().remove();
                break;
            }
            case 5: {
                new SearchUser().search();
                break;
            }
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Choose a valid number. \n");
                mainMenu();
                break;
        }
    }
}
