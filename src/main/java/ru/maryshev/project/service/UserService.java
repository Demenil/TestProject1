package ru.maryshev.project.service;


import java.util.ArrayList;
import java.util.Scanner;

import ru.maryshev.project.entity.*;

import java.util.HashMap;

/**
 * Класс для управления данными о пользователе и привычках
 * */
public class UserService {
    public static HashMap<String, User> userStorage = new HashMap<>(); //Хранилище пользователей
    public static String userKey; //ключ для получения конкретного пользователя


    /**
    * Конструктор для создания сущности по управлению пользователями и привычками
    * */
    public UserService(){};

    /**
     * Метод для старта приложения
     */
    public static void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберете действие в системе:");
        System.out.println("1. Регистрация");
        System.out.println("2. Авторизация");
        System.out.print("Введите номер меню: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                registration();
                break;
            case 2:
                authorization();
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста выберете 1 или 2.");
                break;
        }
    };

    /**
     * Метод для вызова главного меню после регистрации или авторизации
     * */
    public static void getMainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберете раздел меню:");
        System.out.println("1. Управление пользователями");
        System.out.println("2. Управление привычками");
        System.out.print("Введите номер меню: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                getUserMenu(); //Вызов метода для отображения меню пользователя (метод с командами по изменению данных о пользователе)
                break;
            case 2:
                getHabitMenu(); //Вызов метода для отображения меню по привычкам (метод с командами для обработки привычек)
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста выберете 1 или 2.");
                break;
        }
    }


    /**
     *Метод для отображения меню пользователя
     * */
    public static void getUserMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберете раздел меню:");
        System.out.println("1. Изменить имя");
        System.out.println("2. Изменить email");
        System.out.println("3. Изменить пароль");
        System.out.println("4. Удалить аккаунт");
        System.out.println("5. Главное меню");
        System.out.print("Введите номер меню: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                changeName(); //Вызов метода для изменения имени пользователя
                break;
            case 2:
                changeEmail(); //Вызов метода для изменения email пользователя
                break;
            case 3:
                changePassword();//Вызов метода для изменения пароля пользователя
                break;
            case 4:
                deleteUser(); //Вызов метода для удаления пользователя
                break;
            case 5:
                getMainMenu(); //Вызов метода для отображения главного меню
                break;
            default:
                System.out.println("Неверный выбор. Введите число от 1 до 5.");
                break;
        }
    }

    /**
     * Метод для изменения имени пользователя
     * */
    public static void changeName() {
        User user = userStorage.get(userKey); // Получить пользователя по которому требуется изменить имя
        //значение userKey задается в методах registration() и authorization() (при регистрации и авторизации)

        Scanner sc = new Scanner(System.in);
        System.out.println("Текущее имя пользователя: " +user.getName()); //Вывести текущее имя пользователя до изменений
        System.out.print("Введите новое имя: ");
        user.setName(sc.nextLine()); //изменить значение имени у пользователя
        System.out.println("Данные обновлены");
        System.out.println("Измененные данные о пользователе: " + user);
        getUserMenu(); //отобразить меню пользователя
    }

    /**
     * Метод для изменения email пользователя
     * */
    public static void changeEmail() {
        User user = userStorage.get(userKey);// Получить пользователя по которому требуется изменить email
        //значение userKey задается в методах registration() и authorization() (при регистрации и авторизации)

        Scanner sc = new Scanner(System.in);
        System.out.println("Текущий email: " +user.getCredentials().getEmail()); //Вывести текущий email
        System.out.print("Введите новый email: ");
        user.getCredentials().setEmail(sc.nextLine());//изменить email (email -это параметр класса Credentials, сначала извлекается Credentials, а затем меняется его поле)
        System.out.println("Данные обновлены");
        System.out.println("Измененные данные о пользователе: " + user);
        getUserMenu(); //отобразить меню пользователя
    }

    /**
     * Метод для изменения пароля пользователя
     * */
    public static void changePassword() {
        User user = userStorage.get(userKey);// Получить пользователя по которому требуется изменить пароль
        //значение userKey задается в методах registration() и authorization() (при регистрации и авторизации)

        Scanner sc = new Scanner(System.in);
        System.out.println("Текущий пароль: " +user.getCredentials().getPassword());//Вывести текущий пароль
        System.out.print("Введите новый пароль: ");
        user.getCredentials().setPassword(sc.nextLine());//изменить пароль (password -это параметр класса Credentials, сначала извлекается Credentials, а затем меняется его поле)
        System.out.println("Данные обновлены");
        System.out.println("Измененные данные о пользователе: " + user);
        getUserMenu();
    }

    /**
     * Метод для удаления пользователя/аккаунта
     * */
    public static void deleteUser() {
        User user = userStorage.get(userKey); // Получить пользователя (получить нужный аккаунт)
        //значение userKey задается в методах registration() и authorization() (при регистрации и авторизации)
        System.out.println("Данные о пользователе: " +user); //отобразить данные о пользователе

        Scanner sc = new Scanner(System.in); //вывести доп меню для подтверждения удаления
        System.out.println("Вы точно хотите удалить аккаунт?");
        System.out.println("1. Да");
        System.out.println("2. Главное меню");
        System.out.print("Введите номер: ");
        int choice = sc.nextInt();

        if(choice == 1){
            userStorage.remove(userKey); //удалить значение с user из userStorage по ключу userKey
            user = null; //обнулить значение переменной user

            System.out.println("Аккаунт удален, переход на стартовую страницу");
            System.out.println("*******************");
            start(); //перейти на стартовую страницу/выход из учетной записи

        } if(choice == 2) {
            getMainMenu(); //отобразить главное меню

        }else {
            System.out.println("Неверный выбор. Введите число от 1 до 2.");
        }
    }

    /**
     * Метод для регистрации нового пользователя
     * */
    public static void registration(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Регистрация пользователя");

        System.out.print("Введите Ваше имя: ");
        String username = sc.nextLine(); //получить имя пользователя из консоли

        System.out.print("Введите Ваш email: ");
        String email = sc.nextLine(); //получить email пользователя из консоли

        System.out.print("Введите Ваш пароль: ");
        String  password= sc.nextLine(); //получить пароль пользователя из консоли

        User user = new User(username); //Создать нового пользователя с параметром username
        Credentials credentials = new Credentials(email, password); //Создать объект с учетными данными пользователя
        user.setCredentials(credentials); //добавить учетные данные ранее созданному пользователю

        String autentificationString = email + password; //создать уникальный ключ для сохранения пользователя в userStorage
        userKey = autentificationString; //продублировать значения ключа в отдельную переменную, которая будет доступна во всех методах класса UserService

        if(userStorage.containsKey(autentificationString)){ //проверить уникальности пароля и email
            System.out.println("Пользователь с такими учетными данными уже зарегистрирован в системе");
            start(); //перейти на стартовое меню
        }else {
            userStorage.put(autentificationString, user); //записать нового пользователя в систему/userStorage
            System.out.println("Зарегистрирован новый пользователь: " + userStorage.get(autentificationString));
            getMainMenu(); //отобразить главное меню
        }
    }

    /**
     * Метод для авторизации пользователя
     * */
    public static void authorization(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Авторизация");

        System.out.print("Введите Ваш email: ");
        String email = sc.nextLine();//получить email пользователя из консоли

        System.out.print("Введите Ваш пароль: ");
        String  password= sc.nextLine(); //получить пароль пользователя из консоли

        String autentificationString = email + password; //сформировать ключ для поиска пользователя в userStorage
        userKey = autentificationString; //продублировать значения ключа в отдельную переменную, которая будет доступна во всех методах класса UserService

        if(userStorage.containsKey(autentificationString)){ //проверить наличие пользователя в системе/userStorage
            System.out.println("Вы успешно авторизованы в системе");
            getMainMenu();//перейти в главное меню
        }else {
            System.out.println("Пользователь с такими учетными данными не найден");
            start();//перейти на стартовую страницу
        }
    }

    /**
     * Метод для вызова меню по управлению привычками
     * */
    public static void getHabitMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберете раздел меню:");
        System.out.println("1. Создать привычку");
        System.out.println("2. Изменить привычку");
        System.out.println("3. Удалить привычку");
        System.out.println("4. Просмотреть привычку");
        System.out.println("5. Главное меню");
        System.out.print("Введите номер меню: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                createHabit(); //вызвать метод для создания привычки
                break;
            case 2:
                //TODO 12.10.2024, реализовать позже;
                break;
            case 3:
                // TODO 12.10.2024, реализовать позже;
                break;
            case 4:
                // TODO 12.10.2024, реализовать позже;
                break;
            case 5:
                getMainMenu(); //перейти в главное меню
                break;
            default:
                System.out.println("Неверный выбор. Введите число от 1 до 5.");
                break;
        }
    }

    /**
     * Метод по созданию привычки
     * */
    public static void createHabit(){
        User user = userStorage.get(userKey); //получить пользователя для которого нужно создать привычку(поиск по связке email + пароль)

        Scanner sc = new Scanner(System.in);
        System.out.println("Заполните данные о привычке:");

        System.out.println("Введите наименование привычки");
        String habitName = sc.nextLine(); //получить из консоли название привычки
        System.out.println("Введите описание привычки");
        String habitDescription = sc.nextLine(); //получить из консоли описание привычки
        System.out.println("Выберите переодичность привычки:");

        System.out.println("1. Ежедневно");
        System.out.println("2. Еженедельно(значение по умолчанию)");
        String choice = sc.nextLine();

        HabitRate habitRate = HabitRate.WEEKLY; //создать переменную для записи привычки (значение еженедельно задано как значение по умолчанию)

        if(choice.equals("1")){ //обработка выбора пользователя
             habitRate = HabitRate.DAILY; //выбрать переодичность ежедневно из списка HabitRate
        }



        //создание сущности привычка
        Habit newHabit = new Habit(
                habitName, //наименование привычки, полученное из консоли
                habitDescription, //наименование описания привычки, полученное из консоли
                habitRate, //переодичность привычки
                new java.util.Date(), //дата начала привычки (передается текущая дата и время)
                HabitStatus.INPROGRESS //статус привычки, при создании записи передается статус "в процессе"
        );


        ArrayList <Habit> habitList = user.getHabits(); //добавить привычку в список привычек

        if(habitList == null){ //если у пользователя ранее отсутствовали привычки
            habitList = new ArrayList<>(); //создать пустой список привычек
            habitList.add(newHabit); //добавить новую привычку
        }
        else //если у пользователя уже есть записи о других привычках
        {
            habitList = user.getHabits(); //получить список ранее созданных привычек пользователя
            habitList.add(newHabit); //добавить новую привычку
        };

        user.setHabits(habitList); //обновить список привычек пользователя
        System.out.println("Обновленный список привычек:  " + user.getHabits());

        getHabitMenu(); //перейти в меню по управлению привычками
    }

}
