package it.einaudi.mercury;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Home extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks, FragmentProfilo.log{

	private NavigationDrawerFragment mNavigationDrawerFragment;
	private CharSequence mTitle;	
	ParseUser user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);	
	//	if(user == null){
	//	}
		   Parse.initialize(this, "YK8O3IqlU1lJLNOaP7qevy8T7MNOAaIf8ABS7cp8","XpZ22jySyrERFZ8kiKY1czv6W2DLp8diAroNiWav");
			user = new ParseUser();
		   login();
		/*login statico con account di prova*/
		//login();
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,(DrawerLayout) findViewById(R.id.drawer_layout));
		//avverto l'utente nel caso in cui non sia collegato ad internet
		if(!online() ){
			AlertDialog.Builder dialog = new AlertDialog.Builder(this);
			dialog.setTitle("Attenzione");
			dialog.setMessage("Non sei collegato a nessuna rete");
			dialog.setPositiveButton("OK", new OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
				
			});
			AlertDialog alert = dialog.create(); 
		    alert.show();	
		}
		
		
	}

	private boolean online() {
		// TODO Auto-generated method stub
		ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		if(cm.getActiveNetworkInfo() != null){
		   return cm.getActiveNetworkInfo().isConnectedOrConnecting();
		}else{
		   return false;
		}
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// 	viene gestito l'evento corrispondente all'elemento selezionato nel menu, come 
		//  l'apertura della schermata di login o di registrazione
		FragmentManager fragmentManager = getSupportFragmentManager();
		//fragmentManager.beginTransaction().replace(R.id.container, PlaceholderFragment.newInstance() ).commit();


			switch(position){			
			
			case 0:
				fragmentManager.beginTransaction().replace(R.id.container, new PlaceholderFragment().newInstance() ).commit();
				break;
			case 1:
	            
	            break;
	           
			case 2:
				
			//	fragmentManager.beginTransaction().replace(R.id.container,login).commit();
				break;
				
			case 3:
				
			//	fragmentManager.beginTransaction().replace(R.id.container,signup).commit();
				break;
				
			}
		}
	//}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
		//actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#007fff")));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.home, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private static final String ARG_SECTION_NUMBER = "section_number";

		public PlaceholderFragment newInstance() {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putString(ARG_SECTION_NUMBER, "Benvenuto in Mercury");
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_home, container,false);
			TextView textView = (TextView) rootView.findViewById(R.id.section_label);
			textView.setText("Benvenuto in Mercury");
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((Home) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
				
		
	}

	//@Override
	public void login() {
		// TODO Auto-generated method stub
		ParseUser.logInInBackground("Prova", "prova", new LogInCallback() {
			  public void done(ParseUser user, ParseException e) {
			    if (user != null) {
			      // Hooray! The user is logged in.
			    	Toast.makeText(getApplicationContext(),"Accesso Eseguito", Toast.LENGTH_SHORT).show();
			    } else {
			      // Signup failed. Look at the ParseException to see what happened.
			    	Toast.makeText(getApplicationContext(), "Accesso Non Eseguito", Toast.LENGTH_SHORT).show();
			    }
			  }
			});			
	}
	
}
