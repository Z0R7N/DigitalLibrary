package ru.zoran.library.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message = "Name should not empty")
    @Size(min = 2, max = 40, message = "Name must be between 2 and 40 characters")
    private String name;

    @Min(value = 1900, message = "Date of birth should be greater then 1900 year")
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
