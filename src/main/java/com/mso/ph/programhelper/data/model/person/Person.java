package com.mso.ph.programhelper.data.model.person;

public class Person {
    private String id;
    private String sex;
    private String name;
    private String surname;
    private boolean activeInSchool;
    private boolean isServant;
    private boolean isElder;
    private boolean canMicrophone;
    private boolean canZoom;
    private boolean canBeOrderly;

    // Getters and Setters for each field
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

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

    public boolean isActiveInSchool() {
        return activeInSchool;
    }

    public void setActiveInSchool(boolean activeInSchool) {
        this.activeInSchool = activeInSchool;
    }

    public boolean isServant() {
        return isServant;
    }

    public void setServant(boolean isServant) {
        this.isServant = isServant;
    }

    public boolean isElder() {
        return isElder;
    }

    public void setElder(boolean isElder) {
        this.isElder = isElder;
    }

    public boolean isCanMicrophone() {
        return canMicrophone;
    }

    public void setCanMicrophone(boolean canMicrophone) {
        this.canMicrophone = canMicrophone;
    }

    public boolean isCanZoom() {
        return canZoom;
    }

    public void setCanZoom(boolean canZoom) {
        this.canZoom = canZoom;
    }

    public boolean isCanBeOrderly() {
        return canBeOrderly;
    }

    public void setCanBeOrderly(boolean canBeOrderly) {
        this.canBeOrderly = canBeOrderly;
    }
}
