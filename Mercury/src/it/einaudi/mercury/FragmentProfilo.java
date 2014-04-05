package it.einaudi.mercury;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;

public class FragmentProfilo extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View root = inflater.inflate(R.layout.fragment_profilo,container,false);
		TextView nome = (TextView)root.findViewById(R.id.nome);
		TextView cognome = (TextView)root.findViewById(R.id.cognome);
		TextView descrizione = (TextView)root.findViewById(R.id.descrizione);
		
		
		

		return root;
	}
	public interface log{
		void login();
	}
}
