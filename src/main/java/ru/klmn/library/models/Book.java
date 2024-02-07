package ru.klmn.library.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {

    private String fullName;
    private int YearOfBirth;

    public Book(String fullName, int yearOfBirth) {
        this.fullName = fullName;
        YearOfBirth = yearOfBirth;
    }
}