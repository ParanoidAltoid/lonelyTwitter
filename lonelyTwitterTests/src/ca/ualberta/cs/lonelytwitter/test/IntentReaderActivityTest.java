package ca.ualberta.cs.lonelytwitter.test;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.R;
import junit.framework.TestCase;


public class IntentReaderActivityTest extends ActivityInstrumentationTestCase2<IntentReaderActivity>
{ 
	public IntentReaderActivityTest() {
		super(IntentReaderActivity.class);
	}



	public void testSendText(){ 
		String text = "hello word";
		int code = IntentReaderActivity.NORMAL; 
		startWithText(text, code); 
	} 

	public void testReverse(){
		String text = "radar";
		
		startWithText(text, IntentReaderActivity.REVERSE);
		assertEquals(text, text);
	}
	
	public void testOnScreen(){
		
		IntentReaderActivity activity = startWithText("test", IntentReaderActivity.NORMAL);
		
		ViewAsserts.assertOnScreen( activity.getWindow().getDecorView(),
				activity.findViewById(R.id.intentText) );
	}
	
	
	private IntentReaderActivity startWithText(String text, int code){
		Intent intent = new Intent(); 
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, code); 
		setActivityIntent(intent); 
		return (IntentReaderActivity) getActivity();
	}
	
}