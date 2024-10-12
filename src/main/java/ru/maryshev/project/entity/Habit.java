package ru.maryshev.project.entity;

import java.util.Date;

public class Habit {
    private String habitName;
    private String habitDescription;
    private HabitRate habitRate;
    private Date habitDateStart;
    private HabitStatus habitStatus;

    public Habit(String name, String description, HabitRate rate, Date dateStart, HabitStatus status){
        this.habitName = name;
        this.habitDescription = description;
        this.habitDateStart = dateStart;
        this.habitRate =rate;
        this.habitStatus =status;
    }

    public String getHabitName() {
        return habitName;
    }

    public String getHabitDescription() {
        return habitDescription;
    }

    public HabitRate getHabitRate() {
        return habitRate;
    }

    public Date getHabitDateStart() {
        return habitDateStart;
    }

    public HabitStatus getHabitStatus() {
        return habitStatus;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public void setHabitDescription(String habitDescription) {
        this.habitDescription = habitDescription;
    }

    public void setHabitRate(HabitRate habitRate) {
        this.habitRate = habitRate;
    }

    public void setHabitDateStart(Date habitDateStart) {
        this.habitDateStart = habitDateStart;
    }

    public void setHabitStatus(HabitStatus habitStatus) {
        this.habitStatus = habitStatus;
    }

    public String toString() {
        return "{"
                + "название='" + habitName
                + ", описание=" + habitDescription
                + ", периодичность=" + habitRate
                + ", дата начала=" + habitDateStart
                + ", статус=" + habitStatus
                + '}';
    }
}
