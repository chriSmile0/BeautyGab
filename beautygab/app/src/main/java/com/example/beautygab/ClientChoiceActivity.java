package com.example.beautygab;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ClientChoiceActivity extends AppCompatActivity  implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cliente_choice);
	}

	@SuppressLint("NonConstantResourceId")
	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.button_coiffure) {//search coiffeuse
			Toast.makeText(ClientChoiceActivity.this, "You selected hairdress room ", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.button_visage) {//search visage
			Toast.makeText(ClientChoiceActivity.this, "You selected face room ", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.button_mains) {//search main
			Toast.makeText(ClientChoiceActivity.this, "You selected hand room ", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.button_corps) {
			Toast.makeText(ClientChoiceActivity.this, "You selected body room ", Toast.LENGTH_SHORT).show();
			//search corps
		}

		Intent clientactivity = new Intent(ClientChoiceActivity.this, ClientActivity.class);
		startActivity(clientactivity);
	}

	public void search_hairdresser() {

	}

	public void search_face_professional() {

	}

	public void search_hand_professional() {

	}

	public void search_body_professional() {

	}

}