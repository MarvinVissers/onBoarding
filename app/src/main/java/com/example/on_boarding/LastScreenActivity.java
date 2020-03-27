package com.example.on_boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.on_boarding.controller.studentController;

public class LastScreenActivity extends AppCompatActivity {

    private studentController ctrlStudent;

    private TextView tvAfsluiting;
    private TextView txtTip;
    private ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_screen);

        imageView = findViewById(R.id.imageView);
        txtTip = findViewById(R.id.tvWeetje);

        Intent mainIntent = getIntent();
        Bundle bundle = mainIntent.getExtras();
        int iStudentnummer = bundle.getInt("student");


        // Student gegevens ophalen
        tvAfsluiting = findViewById(R.id.tvAfsluitingTekst);

        // Student controller aanspreken
        this.ctrlStudent = new studentController(getBaseContext(), tvAfsluiting, 6, iStudentnummer);

        // Student ophalen via de api
        ctrlStudent.getStudent();
    }
}
