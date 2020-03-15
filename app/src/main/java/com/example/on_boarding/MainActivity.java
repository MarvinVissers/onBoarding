package com.example.on_boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView txtAfsluiting;
    TextView txtAfsluitingText;
    TextView txtTip;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAfsluiting = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        txtAfsluitingText = findViewById(R.id.txtAfsluiting);
        txtTip = findViewById(R.id.textView2);



    }
}
