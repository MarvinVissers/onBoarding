package com.example.on_boarding.helper;

/**
 *
 * @author Marvin Vissers
 */

public interface Persoon {

    // Functie voor het krijgen van de gegevens van de persoon
    void getStudent();

    // Functie voor het opslaan van de feedback over zijn gegevens
    void opslaanGegevensCorrect(int iGegevensCorrect);

    // Functie voor het opslaan van de feedback
    void opslaanFeedback(int iScore, String sOpmerking);
}
