package com.example.springmvc.entity;

public class User {
    String name,mail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
