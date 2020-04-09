package com.example.on_boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Scherm2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scherm2);
        Intent mainIntent = new Intent(this, MainActivity.class);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int iStudentnummer = bundle.getInt("student");
    }

    public void naarScherm3(View v) {
        Intent mainIntent = getIntent();
        Bundle bundle = mainIntent.getExtras();
        int iStudentnummer = bundle.getInt("student");

        Intent intent = new Intent(this, BoekActivity.class);
        intent.putExtra("student", iStudentnummer);
        startActivity(intent);
    }

    public void vorigScherm(View view) {
        Intent mainIntent = getIntent();
        Bundle bundle = mainIntent.getExtras();
        int iStudentnummer = bundle.getInt("student");
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("student", iStudentnummer);
        startActivity(intent);
    }
}
