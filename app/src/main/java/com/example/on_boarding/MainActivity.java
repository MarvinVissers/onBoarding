package com.example.on_boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.on_boarding.helper.VolleyHelper;
import com.example.on_boarding.modal.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Student mdlStudent;

    private VolleyHelper helper;

    private int iStudentnummer = 1;
    private ArrayList<Student> lijst = new ArrayList();

    /**
     * constructor, waarin video wordt gemaakt en laten zien
     * model wordt aangemaakt
     * json aanvraag wordt gestart
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = findViewById(R.id.video_view);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Gegevens doorsturen naar database sturen
        helper = new VolleyHelper(getBaseContext(), "https://adaonboarding.ml/t4/");
        helper.get("GetStudent?studentnummer=" + iStudentnummer, null, this, this);
    }

    /**
     * 2e scherm wordt gemaakt
     * data wordt meegestuurd
     */
    public void Scherm2(View v) {
        Intent intent = new Intent(this, Scherm2.class);
        intent.putExtra("student", iStudentnummer);
        startActivity(intent);
    }

    /**
     *
     * @param error Als er een error is met het ophalen van json
     */
    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println(error);
    }

    /**
     *
     * @param response Wat er gebeurt als er json teruggegeven wordt uit de api
     */
    @Override
    public void onResponse(JSONObject response) {
        try {
            // JSONArray ophalen
            JSONArray array = response.getJSONArray("item");

            // Kijken of deze leeg is, zodat er geen error onstaat bij geven feedback of gegevens correct
            if(array != null && array.length() > 0 ) {
                for (int i = 0; i < array.length(); i++) {
                    lijst.add(new Student(array.getJSONObject(i)));
                }

                TextView txtWelkom = findViewById(R.id.txtWelkom);

                // Door de array lopen
                for (Student StudentArray : lijst) {
                    // Teksvelden vullen met gegevens student
                    txtWelkom.setText("Welkom " + StudentArray.getStudentVoornaam());
                }
            }
        }catch (JSONException e){
            System.out.println(e);
        }
    }

}
