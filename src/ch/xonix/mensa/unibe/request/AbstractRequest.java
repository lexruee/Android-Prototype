package ch.xonix.mensa.unibe.request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;

public abstract class AbstractRequest extends AsyncTask<String,Void,String>{

	
	
	public abstract String getServiceUri();
	
	@Override
	protected String doInBackground(String... params) {
		DefaultHttpClient client = new DefaultHttpClient();
		Uri serviceURI = Uri.parse(this.getServiceUri());
		Builder uriBuilder = serviceURI.buildUpon();

		HttpGet httpGet = new HttpGet(uriBuilder.build().toString());
		try {
			HttpResponse response = client.execute(httpGet);
			InputStream is = response.getEntity().getContent();
			return this.convertInputStreamToString(is);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private String convertInputStreamToString(InputStream is) throws IOException {
		BufferedReader bf = new BufferedReader(
				new InputStreamReader(is));
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = bf.readLine()) != null) {
			sb.append(line);
		}
		bf.close();
		return sb.toString();
	}

}
