package alex.project042;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private MyTask mt;
	private Button btStart;
	private TextView tv;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.tv);
		btStart = (Button) findViewById(R.id.btStart);
	}

		
	
	public void onClickStart(View v) {
		
		mt = new MyTask();
		mt.execute(5);
		
	}
	
	
	
	public void onClickCansel(View v) {
		
		if (mt != null) mt.cancel(false);
		
	}
	
	
	
    class MyTask extends AsyncTask<Integer, String, Void> {

		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			Log.d("Alex", "Begin");
			
			tv.setText("Begin");
			
			btStart.setEnabled(false);
		}
		
			
		@Override
		protected Void doInBackground(Integer... params) {
			
			Log.d("Alex", "Background");
			
			int i = 0;
			
			try {
				
				while (!isCancelled()){ 
					
					i++;
					
					TimeUnit.SECONDS.sleep(2);
					
					String s = "text " + i;
					String sa = "Alex " + i;
					
					publishProgress(s, sa);			
				}
				
				
				TimeUnit.SECONDS.sleep(1);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		
		
		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);
			
			Log.d("Alex", "Update");
			
			String text = values[0] + values[1];
			
			tv.setText(text);
		}
		
		
		@Override
		protected void onCancelled() {
			super.onCancelled();
			
			Log.d("Alex", "Cancel");
			tv.setText("Cancel");
			btStart.setEnabled(true);
		}
		
		
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			
			Log.d("Alex", "End");
			
			tv.setText("End");
			btStart.setEnabled(true);
		}
		
		
	}
	

}
