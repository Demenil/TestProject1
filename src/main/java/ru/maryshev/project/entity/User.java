package ru.maryshev.project.entity;

import java.util.ArrayList;

public class User {

    private String name;
    private String surname;
    private String patronymic;
    private Credentials credentials;

    private ArrayList <Habit> habits;

    public User (String name){
        this.name =name;
    }

    public User (String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public User (String name, String surname, String patronymic){
        this.name = name;
        this.surname = surname;
        this.patronymic =patronymic;
    }

    public String getName(){
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    public ArrayList <Habit> getHabits() {
        return habits;
    }

    public void setHabits(ArrayList <Habit> habits) {
        this.habits = habits;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public String toString() {
        return "Данные о пользователе{"
                + "имя='" + name
                + ", фамилия=" + surname
                + ", отчество=" + patronymic
                + ", привычки=" + habits
                + ", учетные данные=" + credentials
                + '}';
    }
}
