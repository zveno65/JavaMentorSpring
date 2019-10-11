package ru.plotnikov.form;

import lombok.Data;

@Data
public class UserForm {
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private String name;
    private int age;
}
