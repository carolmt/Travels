package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

public class Travels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travels);

        //Referenciamos el ImageSwitcher
        ImageSwitcher IS = findViewById(R.id.switcherTravels);

//Configuramos el ViewFactory
        IS.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });
        //Una vez configurado ya podemos cambiar las imágenes
        IS.setImageResource(R.drawable.image1);


        RecyclerView recyclerView = findViewById(R.id.recyclerTravel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<Integer> fotosTravel = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int resourceId = getResources().getIdentifier("image" + i, "drawable", getPackageName());
            fotosTravel.add(resourceId);
        }

        TravelsAdapter adapter = new TravelsAdapter(fotosTravel);
        recyclerView.setAdapter(adapter);
    }

}