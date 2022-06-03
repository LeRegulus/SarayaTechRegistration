package model;

import java.time.LocalDate;

public class Student {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String trainingDuration;
    private LocalDate registrationDate;

    private static long numb = 1;

    public Student(String firstname, String lastname, LocalDate dateOfBirth, String trainingDuration, LocalDate registrationDate) {
        this.id = numb;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.trainingDuration = trainingDuration;
        this.registrationDate = registrationDate;
        numb = numb + 1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTrainingDuration() {
        return trainingDuration;
    }

    public void setTrainingDuration(String trainingDuration) {
        this.trainingDuration = trainingDuration;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
