package alex.project001;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class TwoActivity extends Activity implements OnEditorActionListener{

	EditText et;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		
		et = (EditText) findViewById(R.id.etQuestion);
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		
		if(actionId == EditorInfo.IME_ACTION_SEND){
			
			
			Toast.makeText(getApplicationContext(), "send", Toast.LENGTH_LONG).show();
			
			return true;
		}
		
		return false;
	}
	
}
