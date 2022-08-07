package ru.zoran.library.models;

public class Person {
    private int id;
    private String name;
    private int birth;

    public Person(String name, int birth) {
        this.name = name;
        this.birth = birth;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
