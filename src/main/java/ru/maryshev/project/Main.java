package ru.maryshev.project;

import ru.maryshev.project.service.UserService;

public class Main {
    public static void main(String[] args) {
       UserService service = new UserService();
       service.start();
    }
}