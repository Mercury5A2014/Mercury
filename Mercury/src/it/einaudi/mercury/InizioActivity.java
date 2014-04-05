package it.einaudi.mercury;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;

public class InizioActivity extends ActionBarActivity {
	
	private final static String TEXT_DATA_KEY = "textData";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		String flag = prefs.getString(TEXT_DATA_KEY, "false");
		
		SharedPreferences.Editor editor = prefs.edit();
		
		if(flag.contentEquals("false")){
			startActivity(new Intent(this, IntroActivity.class));
			finish();
		} else {
			Intent i = new Intent(this, Home.class);			
			startActivity(i);
		}
		
		//Toast.makeText(getApplicationContext(), r, Toast.LENGTH_SHORT).show();
		
	/*	if(r.contentEquals("vero")){
			Toast.makeText(getApplicationContext(),"Reset eseguito!",Toast.LENGTH_SHORT).show();
			editor.clear();
			editor.commit();
		}
*/
	}

}
