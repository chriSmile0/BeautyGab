package com.example.beautygab;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.Random;

/** @noinspection CallToPrintStackTrace*/
public class ClientActivity<DatabaseReference> extends AppCompatActivity implements View.OnClickListener {
	EditText fnameEditText;
	EditText nameEditText;
	static String fullName = "ah";
	static String transferName;

	EditText wordpass;
	String wdpass;
	private Object string;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_client);
	}

	@SuppressLint("NonConstantResourceId")
	@Override
	public void onClick(View v) {
		if(v.getId() ==  R.id.send_button_cliente_information) {
			Toast.makeText(ClientActivity.this,  "Infos", Toast.LENGTH_SHORT).show();
			cliente_send_information(v);
		}
	}


	public void cliente_send_information(View v)  {
		fnameEditText = findViewById(R.id.fname_cliente);
		nameEditText = findViewById(R.id.name_cliente);
		wordpass = findViewById(R.id.pass_cliente);

		fullName = fnameEditText.getText().toString();
		fullName += " " + nameEditText.getText().toString();
		wdpass = wordpass.getText().toString();
		fullName += " " + "password";

		if(fnameEditText.getText().toString().equals("Chris")) {
			Intent connexion_activity = new Intent(ClientActivity.this, ClientActivityConnexion.class);
			connexion_activity.putExtra(ClientActivityConnexion.fname, fnameEditText.getText().toString());
			startActivity(connexion_activity);
		}

	}

	public static String byteArrayToHexString(byte[] b) {
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (byte value : b) {
			int v = value & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	public static byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		return b;
	}


	private static byte[] encrypted_password(String clear_password) throws NoSuchAlgorithmException {
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		byte[] digest;

		sha.update(clear_password.getBytes());
		digest = sha.digest();

		return digest;
	}

	public int random_digit() {
		Random rand = new Random();
        return rand.nextInt(10);

	}

	public char random_letter() {
		Random rand = new Random();
		int digit_char = rand.nextInt(26);
        return (char) (digit_char + 65);
	}

	public String random_id(int size) {
		StringBuilder id = new StringBuilder();
		int digit;
		char letter;
		for(int i = 0 ; i < size; i++) {
			if(i % 2 == 0) {
				digit = random_digit();
				id.append(digit);
			}
			else {
				letter = random_letter();
				id.append(letter);
			}
		}
		return id.toString();
	}

	public String hide_unrandom_id(String string) {
		//data_firstname.hashCode();

		int size_string = string.length();
		StringBuilder ash = new StringBuilder();
		for(int i = 0 ; i < size_string ; i++) {
			if(string.charAt(i) == 'C') {
				ash.append('9');
			}
		}

		return ash.toString();

	}

	public void setString(Object string) {
		this.string = string;
    }

}
