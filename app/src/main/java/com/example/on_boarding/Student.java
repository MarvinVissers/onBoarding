package com.example.on_boarding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class Student {
    private String StudentAchternaam;
    private String studentNaam;
    private String startDatum;

    public Student(String studentNaam, String startDatum, String studentAchternaam) {
        this.studentNaam = studentNaam;
        this.startDatum = startDatum;
        this.StudentAchternaam = studentAchternaam;
    }

    public Student(JSONObject json) throws JSONException {
        System.out.println(json);
        this.studentNaam = json.getString("student_voornaam");
        this.StudentAchternaam = json.getString("student_achternaam");
        this.startDatum = json.getString("start_datum");
    }



    public String getStudentAchternaam() {
        return StudentAchternaam;
    }

    public void setStudentAchternaam(String studentAchternaam) {
        StudentAchternaam = studentAchternaam;
    }

    public String getStudentNaam() {
        return studentNaam;
    }

    public void setStudentNaam(String studentNaam) {
        this.studentNaam = studentNaam;
    }

    public String getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(String startDatum) {
        this.startDatum = startDatum;
    }
}
