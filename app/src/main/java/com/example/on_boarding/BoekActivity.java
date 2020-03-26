package com.example.on_boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class BoekActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boek);
    }

    //nog niet af.. Hoe werk ik dit uit? Ik wil de front end koppelen. Ik moet namelijk een redirect maken maar weet niet hoe dat moet :(
    public void onBoekBtnClick(View v) {

    }

    public void naarScherm4(View v) {
        Intent boekIntent = getIntent();
        Bundle bundle = boekIntent.getExtras();
        int iStudentnummer = bundle.getInt("student");

        Intent intent = new Intent(this, OntdekRoosendaalActivity.class);
        intent.putExtra("student", iStudentnummer);
        startActivity(intent);
    }

    //connectie maken met de JSON
    public String getOpleidingUrl (int opleidingnr) throws IOException, JSONException {
        URL url = new URL("https://adaonboarding.ml/t4/GetBoekenOpleiding?opleiding=" + opleidingnr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        int responseCode = conn.getResponseCode();
        if(responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        }
        else  // Hier lees je je json uit die je ervoor hebt opgehaald via je API call
        {
            Scanner sc = new Scanner(url.openStream());
            String inline = "";
            while(sc.hasNext()) {
                inline+=sc.nextLine();
            }
            sc.close();

            //Je json omzetten naar een object om zo het specifieke ding er uit te halen wat hier dus opleiding id is
            JSONObject jobj = new JSONObject(inline);
            JSONArray jsonarr_1 = (JSONArray) jobj.get("item");
            JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(0);
            String opleidingId = jsonobj_1.get("opleiding_id").toString();

            //switch zodat elke gebruiker iets anders ziet ... links nog geen return gegeven. Uitzoeken hoe dit moet
            switch(opleidingId)
            {
                case "1":
                    return "https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079169/Ad-Informatica-leerjaar-1";
                case "2":
                    return "https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079170/Ad-Accountancy-leerjaar-1";
                case "3":
                    return ": https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079174/Ad-Bedrijfskunde-leerjaar-1-";
                case "4":
                    return "https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL088447/Built-Environment-leerjaar-1";
                case "5":
                    return "https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079173/Ad-Engineering-leerjaar-1";
                case "6":
                    return "https://www.studystore.nl/";
                case "7":
                    return "https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079166/Ad-Human-Resource-Management-leerjaar-1";
                case "8":
                    return "https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079171/Ad-Logistiek-leerjaar-1";
                case "9":
                    return "https://www.studystore.nl/boekenlijst/Associate-degrees-Academie/2019/BL079172/Ad-Management-leerjaar-1";
                default:
                    return "";
            }
        }
    }
}
