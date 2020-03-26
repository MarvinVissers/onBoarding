package com.example.on_boarding;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.on_boarding.helper.VolleyHelper;
import com.example.on_boarding.modal.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LastScreenActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    TextView txtTip;
    ImageView imageView;
    VolleyHelper helper;

    private ArrayList<Student> students;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_screen);

        imageView = findViewById(R.id.imageView);
        txtTip = findViewById(R.id.tvWeetje);
        students = new ArrayList<>();

        Intent mainIntent = getIntent();
        Bundle bundle = mainIntent.getExtras();
        int iStudentnummer = bundle.getInt("student");

        helper = new VolleyHelper(this, "https://adaonboarding.ml/t4");

        helper.get("GetStudent?studentnummer=" + iStudentnummer, null, this, this);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Volley Error", error.toString());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onResponse(JSONObject response) {
        System.out.println(response.toString());

        try {
            // JSONArray ophalen
            JSONArray array = response.getJSONArray("item");

            // Kijken of deze leeg is, zodat er geen error onstaat bij geven feedback of gegevens correct
            if(array != null && array.length() > 0 ) {
                for (int i = 0; i < array.length(); i++) {
                    students.add(new Student(array.getJSONObject(i)));
                }

                TextView tvAfsluitingTekst = findViewById(R.id.tvAfsluitingTekst);

                // Door de array lopen
                for (Student StudentArray : students) {
                    // Teksvelden vullen met gegevens student
                    String name = StudentArray.getStudentVoornaam() + " " + StudentArray.getStudentAchternaam();
                    String date = StudentArray.getStudentStartDaturm();
                    tvAfsluitingTekst.setText("Gefeliciteerd " + name +"! Je hebt bij deze je onboarding afgerond! Je opleiding start op " + date + "! Tot dan!");
                }
            }
        }catch (JSONException e){
            System.out.println(e);
        }
    }
}
