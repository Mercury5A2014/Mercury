package it.einaudi.mercury;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IntroActivity extends ActionBarActivity {
	
	String TEXT_DATA_KEY = "textData";
	EditText username;
	EditText password;
	EditText confermaPassword;
	EditText mail;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		
		username = (EditText)findViewById(R.id.etUtente);
		password = (EditText)findViewById(R.id.etPassword);
		confermaPassword = (EditText)findViewById(R.id.etConfermaPassword);
		mail = (EditText)findViewById(R.id.etMail);
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(TEXT_DATA_KEY, "true");
		editor.commit();
				
	}

	public void registrazione(View v){
		if(password.getText().toString() == confermaPassword.getText().toString() ){
			Intent Main = new Intent(this, InizioActivity.class);
			startActivity(Main);
			finish();
		}else{
			Toast.makeText(getApplication(),"Password errata",Toast.LENGTH_SHORT).show();
		}
	}
}
