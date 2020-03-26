package com.example.on_boarding.modal;

import android.content.Context;
import android.widget.Toast;

public class Bezienswaardigheid {

    public Bezienswaardigheid(){

    }

    //Methode om de Toast af te beelden. De for loop gebruik ik om de duur van de Toast dubbel zo lang te maken.
    public static void laatBerichtZien(Context mContext, String message) {
        for (int i = 0; i < 2; i++) {
            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
        }
    }
}
