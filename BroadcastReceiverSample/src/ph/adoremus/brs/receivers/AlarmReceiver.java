package ph.adoremus.brs.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Toast.makeText(arg0, "Lorem ipsum dolor sit amet", Toast.LENGTH_LONG).show();
		Vibrator vibrator = (Vibrator) arg0.getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate((1000*2));
	}

}
