package com.example.on_boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.on_boarding.controller.studentController;


public class MainActivity extends AppCompatActivity {

    private studentController ctrlStudent;

    private TextView txtWelkom;

    private int iStudentnummer = 1;

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

        txtWelkom = findViewById(R.id.txtWelkom);

        // Controller aanspreken
        ctrlStudent = new studentController(getBaseContext(), txtWelkom, 1, iStudentnummer);

        // Student ophalen
        ctrlStudent.getStudent();
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
}
