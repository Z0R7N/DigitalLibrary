package ru.zoran.library.models;

public class Person {
    private int id;
    private String name;
    private int birth;

    public Person(int id, String name, int birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }
}
