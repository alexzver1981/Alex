package alex.project001;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class TwoActivity extends Activity implements OnEditorActionListener{

	EditText et;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		
		et = (EditText) findViewById(R.id.etQuestion);
		et.setOnEditorActionListener(this);
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		
		if(actionId == EditorInfo.IME_ACTION_SEND){
			
			Intent intent = new Intent();
			intent.putExtra("text", et.getText().toString());
			setResult(RESULT_OK, intent);
			finish();
			return true;
		}
		
		return false;
	}
	
}
