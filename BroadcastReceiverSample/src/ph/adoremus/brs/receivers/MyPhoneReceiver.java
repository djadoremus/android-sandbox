package ph.adoremus.brs.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyPhoneReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Bundle extras = arg1.getExtras();
		if (extras != null){
			String state = extras.getString(TelephonyManager.EXTRA_STATE);
			Log.i("BRS", state);
			if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
				String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
				Log.w("BRS", phoneNumber);
			}
		}
	}

}
