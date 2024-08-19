package com.example.beautygab;

//window size 730 dp//
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
	Button btnclick;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnclick = findViewById(R.id.enter_button);
		btnclick.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v.getId() ==  R.id.enter_button) {
			Toast.makeText(MainActivity.this,  "Enter in the choice room", Toast.LENGTH_SHORT).show();
			setContentView(R.layout.second_page);
		}
		if(v.getId() == R.id.txtcliente) {
			Intent clientchoiceactivity = new Intent(MainActivity.this,ClientChoiceActivity.class);
			startActivity(clientchoiceactivity);
		}
		if(v.getId() == R.id.txtprofessionnelle) {
            Intent professionalactivity  = new Intent(MainActivity.this,ProfessionalActivity.class);
			startActivity(professionalactivity);

		}
	}
}