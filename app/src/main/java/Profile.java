package com.example.datamodel;

public class Profile {
    private String name;
    private int age;
    private String email;
    private String bio;

    public Profile(String name, int age, String email, String bio) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.bio = bio;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getBio() { return bio; }
}
