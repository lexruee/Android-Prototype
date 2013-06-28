package ch.xonix.mensa.unibe;

import ch.xonix.mensa.unibe.model.Mensa;
import ch.xonix.mensa.unibe.model.Model;
import ch.xonix.mensa.unibe.request.MensasRequest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends Activity {

	private ListView mensaListView;
	private ArrayAdapter<Mensa> mensaListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//create a array adapter
		mensaListAdapter = new ArrayAdapter<Mensa>(this,android.R.layout.simple_list_item_1);
		mensaListView = (ListView) this.findViewById(R.id.mensa_list);
		mensaListView.setAdapter(mensaListAdapter);
		new MensasRequest(mensaListAdapter).execute();	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
