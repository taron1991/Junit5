package junit;

import java.util.*;

public class User {

    private int id;
    private String name;
    private int age;
    private Gender gender;

    private static Map<Integer, User> allUsers;
    private static int countId = 0;



    public User(String name, int age, Gender gender) {
        if (allUsers == null) {
            allUsers = new HashMap<>();
        }

        this.name = name;
        this.age = age;
        this.gender = gender;

        if (!hasUser()) {
            countId++;
            this.id = countId;
            allUsers.put(id, this);
        }
    }

    private boolean hasUser(){
        for (User user : allUsers.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true; //если обьект одинаковый то не вставляем в мапу
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + gender +
                '}';
    }
    public static List<User> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }

    //найти всех людей по какому-то полу
    public static List<User> getAllUsers(Gender gender){
        List<User> listAllUsers = new ArrayList<>();
        for (User user : allUsers.values()){
            if (user.gender == gender){
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }

    public static int getHowManyUsers(){
        return allUsers.size();
    }

    //сколько людей кол-во по опред полу
    public static int getHowManyUsers(Gender gender){
        return getAllUsers(gender).size();
    }

    //суммируем возраста всех людей
    public static int getAllAgeUsers(){
        int countAge = 0;
        for (User user : allUsers.values()){
            countAge += user.age;
        }
        return countAge;
    }

    //суммируем возраста всех людей по опред полу
    public static int getAllAgeUsers(Gender gender){
        int countAge = 0;
        for (User user : getAllUsers(gender)){
            countAge += user.age;
        }
        return countAge;
    }

    //ср арифмет возрастов всех людей
    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers() / getHowManyUsers();
    }

    //ср арифмет возрастов всех людей по опр полу
    public static int getAverageAgeOfAllUsers(Gender gender){
        return getAllAgeUsers(gender) / getHowManyUsers(gender);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
