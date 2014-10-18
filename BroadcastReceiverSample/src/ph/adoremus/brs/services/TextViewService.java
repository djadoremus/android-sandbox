package ph.adoremus.brs.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class TextViewService extends Service{
	
	private TextViewBinder binder = new TextViewBinder();
	private Thread tRunningText;
	
	@Override
	public int onStartCommand(final Intent intent, int flags, int startId) {
		Log.i("SERVICE", intent.getExtras().getString("prefix"));
		tRunningText = new Thread(new Runnable() {
			@Override
			public void run() {
				int i=0;
				while(i<=10){
					try {
						i++;
						Log.i("SERVICE", "Do some background process here! " + intent.getExtras().getString("prefix") + " " + i);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						Log.e("SERVICE", e.getLocalizedMessage());
					}
				}
				stopSelf();
			}
		});
		tRunningText.start();
		return Service.START_NOT_STICKY;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
	
	public class TextViewBinder extends Binder{
		TextViewService getService(){
			return TextViewService.this;
		}
	}
	
}
