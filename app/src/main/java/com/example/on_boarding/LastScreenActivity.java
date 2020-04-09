package com.example.on_boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class LastScreenActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    TextView txtAfsluiting;
    TextView txtAfsluitingText;
    TextView txtTip;
    ImageView imageView;
    VolleyHelper helper;

    private ArrayList<Student> students;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_screen);

        txtAfsluiting = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        txtAfsluitingText = findViewById(R.id.txtAfsluiting);
        txtTip = findViewById(R.id.textView2);
        students = new ArrayList<>();


        helper = new VolleyHelper(this, "http://192.168.8.15/bp3api");

        helper.get("GetStudent?studentnummer=2", null, this, this);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Volley Error", error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        System.out.println(response.toString());

        try {
            students.add(new Student(response));
            // JSONArray ophalen
//            JSONArray array = response.getJSONArray("item");
//
//            // Kijken of deze leeg is, zodat er geen error onstaat bij geven feedback of gegevens correct
//            if(array != null && array.length() > 0 ) {
//                for (int i = 0; i < array.length(); i++) {
//                    students.add(new Student(array.getJSONObject(i)));
//                }

                    Log.d("TussenLog", students.toString());


                // Door de array lopen
                for (Student StudentArray : students) {
                    System.out.println(StudentArray.toString());
                    // Teksvelden vullen met gegevens student
                    String name = StudentArray.getStudentNaam() + " " + StudentArray.getStudentAchternaam();
                    String date = StudentArray.getStartDatum();
                    txtAfsluitingText.setText("Gefeliciteerd " + name +"! Je hebt bij deze je onboarding afgerond! Je opleiding start op " + date + "! Tot dan!");

                }

        }catch (JSONException e){
            System.out.println(e);
        }
    }
}
