package domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    private String name;
    private String email;
    private int age;
    private String height;

    public User(String name, String email, int age, String height) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.height = height;
    }

    public void createUserFile() {
        File usersDirectory = new File("users");

        String[] existingFiles = usersDirectory.list();
        int fileCount = existingFiles != null ? existingFiles.length : 0;

        String fileName = (fileCount + 1) + "-" + this.name.toUpperCase().replaceAll("\\s+", "") + ".txt";
        File file = new File(usersDirectory, fileName);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(this.name + '\n' + this.email + '\n' + this.age + '\n' + this.height);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name
                + "\n"
                + email
                + "\n"
                + age
                + "\n"
                + height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
