package com.example.on_boarding.controller;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.on_boarding.helper.VolleyHelper;

public class studentController implements Response.ErrorListener {

    // Classes importeren
    private VolleyHelper helper;
    private int iStudentnummer;

    /**
     * @param ctSActivity Context van het scherm, is nodig om de api te benaderen
     * @param iStudentnummer Het studentnummer van de student
     */
    public studentController(Context ctSActivity, int iStudentnummer){
        this.helper = new VolleyHelper(ctSActivity, "https://adaonboarding.ml/t4/");
        this.iStudentnummer = iStudentnummer;
    }

    /**
     * @param iGegevensCorrect 1 of 0. 1 staat ervoor dat de student zijn of haar gegevens correct zijn en 0 dat de gegevens van de student incorrect zijn.
     */
    public void opslaanGegevensCorrect(int iGegevensCorrect) {
        // Gegevens doorsturen naar database sturen
        helper.post("UpdateStudent?studentnummer=" + iStudentnummer + "&gegevens-correct=" + iGegevensCorrect, null, null, this);
    }

    /**
     * @param iScore De score van de feedback die is gegeven. 1 tot 100
     * @param sOpmerking De opmerking die bij de feeedback is gegevens. Kan leeg zijn.
     */
    public void opslaanFeedback(int iScore, String sOpmerking) {
        // Gegevens doorsturen naar database sturen
        helper.post("SaveFeedback?score=" + iScore + "&opmerking=" + sOpmerking, null, null, this);
    }

    /**
     *
     * @param error Als er een error is met het ophalen van json
     */
    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println(error);
    }
}
