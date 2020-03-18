package com.example.on_boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.squareup.picasso.Picasso;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OntdekRoosendaalActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    public static OntdekRoosendaalActivity activity;
    private Bezienswaardigheid bezienswaardigheid;
    private VolleyHelper helper;
    private JSONArray result;

    //Constructor is nodig om de activity te initieren die als context meegegeven moet worden aan de methode laatBerichtZien
    public OntdekRoosendaalActivity() {
        activity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VolleyHelper initieren op de lokale server. Ik wil een get request uitvoeren om iets terug te krijgen als response.
        // Deze response is in de methode onResponse terug te vinden.
        helper = new VolleyHelper(this, "http://192.168.178.23/Bezienswaardigheden");
        helper.get("api.php?bezienswaardigheid", null, this, this);
    }

    //Methodes om Toast messages te tonen. Losse onclick op elke ImageView gezet zodat ze uniek zijn. Strings staan in values/strings.xml
    public void markt_onclick(View view) {
        bezienswaardigheid.laatBerichtZien(activity, getString(R.string.markt_message));
    }

    public void treinstation_onclick(View view) {
        bezienswaardigheid.laatBerichtZien(activity, getString(R.string.treinstation_message));
    }

    public void skydiving_onclick(View view) {
        bezienswaardigheid.laatBerichtZien(activity, getString(R.string.skydive_message));
    }

    public void roselaar_onclick(View view) {
        bezienswaardigheid.laatBerichtZien(activity, getString(R.string.roselaar_message));
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
            //JSON array maken van de response. Dit vind ik het fijnste uitlezen
            result = response.getJSONArray("item");
            //Uitlezen van de array
            for (int x = 0; x < result.length(); x++) {
                //Nieuw object van elke positite maken
                JSONObject obj = result.getJSONObject(x);
                //Het nummer opslaan waar hij nu door aan het loopen is. Anders kan ik niet de juiste URL bij dat nummer ophalen. Het nummer is uniek.
                int bezienswaardigheid  = obj.getInt("bezienswaardigheid_id");
                //Switch aanmaken
                //Switch gaat zorgen dat bij elk uniek nummer de unieke URL teruggeven wordt en via Picasso in de imageView geladen wordt.
                switch (bezienswaardigheid)
                {
                    case 1: String treinstationImageUrl = obj.getString("foto").trim();
                    Picasso.get().load(treinstationImageUrl).into(imageViewTreinstation);
                    break;

                    case 2: String marktImageUrl = obj.getString("foto").trim();
                    Picasso.get().load(marktImageUrl).into(imageViewMarkt);
                    break;

                    case 3: String skydiveImageUrl = obj.getString("foto").trim();
                    Picasso.get().load(skydiveImageUrl).into(imageViewSkydiving);
                    break;

                    case 4: String roselaarImageUrl = obj.getString("foto").trim();
                    Picasso.get().load(roselaarImageUrl).into(imageViewRoselaar);
                    break;
                }
            }
           } catch (JSONException e) {
              e.printStackTrace();
        }
    }
}
