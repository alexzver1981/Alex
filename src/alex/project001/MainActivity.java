package alex.project001;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
	}


	public void onClickSend(View v) {
		
		Intent intent = new Intent(this, TwoActivity.class);
		startActivity(intent);
		
	}
	

}
