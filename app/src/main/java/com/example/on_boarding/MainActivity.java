package com.example.on_boarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    MasterData masterData;
    public String imageUrlTreinstation = "https://img-brabant.rgcdn.nl/917b4c0de8ca48c9b194cc164da4aa10/opener/Het-treinstation-in-Roosendaal.jpg";
    public String imageUrlMarkt = "https://monumentje.files.wordpress.com/2012/02/markt-roosendaal.jpg";
    public String imageUrlSkydiving = "https://www.bebbu.com/storage/media/3140/responsive-images/indoor-skydive-roosendaal-2___default_560_450.jpg";
    public String imageUrlRoselaar = "https://www.scn.today/wp-content/uploads/2018/03/NL-RO-2016-entree-anvers.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageViewMarkt = findViewById(R.id.imageView);
        ImageView imageViewTreinstation = findViewById(R.id.imageView2);
        ImageView imageViewSkydiving = findViewById(R.id.imageView3);
        ImageView imageViewRoselaar = findViewById(R.id.imageView4);


        //Loading image using Picasso
        Picasso.get().load(imageUrlMarkt).into(imageViewMarkt);
        Picasso.get().load(imageUrlTreinstation).into(imageViewTreinstation);
        Picasso.get().load(imageUrlSkydiving).into(imageViewSkydiving);
        Picasso.get().load(imageUrlRoselaar).into(imageViewRoselaar);

    }

    public void displayToast(String message) {

        for (int i=0; i < 3; i++) {
            Toast.makeText(getApplicationContext(), message,
                    Toast.LENGTH_LONG).show();
        }
    }

    public void showTreinstationBericht(View view) {
        displayToast(getString(R.string.treinstation_message));
    }

    public void showMarktBericht(View view) {
        displayToast(getString(R.string.markt_message));

    }

    public void showSkydiveBericht(View view) {
        displayToast(getString(R.string.skydive_message));
    }

    public void showRoselaarBericht(View view) {
        displayToast(getString(R.string.roselaar_message));
    }

}
