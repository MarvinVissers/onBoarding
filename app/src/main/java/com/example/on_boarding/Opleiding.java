package com.example.on_boarding;

import java.util.Date;

public class Opleiding {
    private int OpleidingNummer;
    private String OpleidingNaam;
    private String StartDatum;

    public int getOpleidingNummer() {
        return OpleidingNummer;
    }

    public void setOpleidingNummer(int opleidingNummer) {
        OpleidingNummer = opleidingNummer;
    }

    public String getOpleidingNaam() {
        return OpleidingNaam;
    }

    public void setOpleidingNaam(String opleidingNaam) {
        OpleidingNaam = opleidingNaam;
    }

    public String getStartDatum() {
        return StartDatum;
    }

    public void setStartDatum(String startDatum) {
        StartDatum = startDatum;
    }
}
