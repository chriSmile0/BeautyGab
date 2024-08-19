package com.example.beautygab;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ClientActivityConnexion extends AppCompatActivity  implements View.OnClickListener {
    public static String fname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_connexion);
        fname = getIntent().getStringExtra(ClientActivity.transferName);
        TextView textView = findViewById(R.id.connexion_view); // where someId is the id you give a TextVIew in your xml file
        String s = "Bienvenue " + fname;
        textView.setText(s);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

    }
}
