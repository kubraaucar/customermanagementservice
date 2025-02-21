package com.example.customermanagementservice.controller;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


public class CustomerRequest {
    @NotBlank
    private String name;
    private String surname;
    private long citizenNumber;
    private Date birthDate;
    private boolean isActive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(long citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
