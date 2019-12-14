package com.example.theproject;

public class Profession {
    private String profession;
    private int grade;

    public Profession( String profession, int grade) {
        this.profession = profession;
        this.grade = grade;
    }

    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) { this.profession = profession; }

    public int getGrade() { return this.grade; }

    public void  setGrade(int grade) {this.grade = grade; }

    @Override
    public String toString(){
        return "[ " + this.getProfession() + " | " + this.getGrade() + " ]";
    }
}
