package com.example.on_boarding;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.on_boarding.helper.VolleyHelper;
import com.example.on_boarding.modal.Bezienswaardigheid;
import com.example.on_boarding.modal.Student;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

import androidx.appcompat.app.AppCompatActivity;

public class OntdekRoosendaalActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    public static OntdekRoosendaalActivity activity;
    private Bezienswaardigheid ontdek;
    private VolleyHelper helper;
    private JSONArray result;

    //Constructor is nodig om de activity te initieren die als context meegegeven moet worden aan de methode laatBerichtZien
    public OntdekRoosendaalActivity() {
        activity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ondek_roosendaal);

        //VolleyHelper initieren op de lokale server. Ik wil een get request uitvoeren om iets terug te krijgen als response.
        // Deze response is in de methode onResponse terug te vinden.
        helper = new VolleyHelper(this, "https://adaonboarding.ml/t4/");
        helper.get("GetBezienswaardigheid?bezienswaardigheid=roosendaal", null, this, this);
    }

    public void naarFeedbackActivity(View v) {
        Intent mainIntent = getIntent();
        Bundle bundle = mainIntent.getExtras();
        int iStudentnummer = bundle.getInt("student");

        Intent intent = new Intent(this, FeedbackActivity.class);
        intent.putExtra("student", iStudentnummer);
        startActivity(intent);
    }

    //Methodes om Toast messages te tonen. Losse onclick op elke ImageView gezet zodat ze uniek zijn. Strings staan in values/strings.xml
    public void markt_onclick(View view) {
        ontdek.laatBerichtZien(activity, getString(R.string.markt_message));
    }

    public void treinstation_onclick(View view) {
        ontdek.laatBerichtZien(activity, getString(R.string.treinstation_message));
    }

    public void skydiving_onclick(View view) {
        ontdek.laatBerichtZien(activity, getString(R.string.skydive_message));
    }

    public void roselaar_onclick(View view) {
        ontdek.laatBerichtZien(activity, getString(R.string.roselaar_message));
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Volley Error", error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        //ImageViews aanmaken zodat deze later dmv een URL een foto van de API kunnen tonen
        ImageView imageViewMarkt = findViewById(R.id.imageView);
        ImageView imageViewTreinstation = findViewById(R.id.imageView2);
        ImageView imageViewSkydiving = findViewById(R.id.imageView3);
        ImageView imageViewRoselaar = findViewById(R.id.imageView4);

        try {
            result = new JSONArray();
            //JSON array maken van de response. Dit vind ik het fijnste uitlezen
            result = response.getJSONArray("item");
            //Uitlezen van de array
            for (int x = 0; x < result.length(); x++) {
                //Nieuw object van elke positite maken
                JSONObject obj = result.getJSONObject(x);

                //Het nummer opslaan waar hij nu door aan het loopen is. Anders kan ik niet de juiste URL bij dat nummer ophalen. Het nummer is uniek.
                int bezienswaardigheid  = obj.getInt("bezienswaardigheid_id");
                System.out.println(bezienswaardigheid);
                //Switch aanmaken
                //Switch gaat zorgen dat bij elk uniek nummer de unieke URL teruggeven wordt en via Picasso in de imageView geladen wordt.
                switch (bezienswaardigheid)
                {
                    case 1: String treinstationImageUrl = obj.getString("foto").trim();
                        Picasso.get().load(treinstationImageUrl).into(imageViewTreinstation);
                        System.out.println("Foto treinstation");
                        break;

                    case 2: String marktImageUrl = obj.getString("foto").trim();
                        Picasso.get().load(marktImageUrl).into(imageViewMarkt);
                        System.out.println("Foto markt");
                        break;

                    case 3: String skydiveImageUrl = obj.getString("foto").trim();
                        Picasso.get().load(skydiveImageUrl).into(imageViewSkydiving);
                        System.out.println("Foto skydyving");
                        break;

                    case 4: String roselaarImageUrl = obj.getString("foto").trim();
                        Picasso.get().load(roselaarImageUrl).into(imageViewRoselaar);
                        System.out.println("Foto roselaar");
                        break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
