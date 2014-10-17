package ph.adoremus.brs;

import java.util.ArrayList;
import java.util.List;

import ph.adoremus.brs.receivers.AlarmReceiver;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


public class MainActivity extends Activity {
	private ListView lvMenuItems;
	private Button btnAlarm;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        lvMenuItems = (ListView) findViewById(R.id.menuItems);
        btnAlarm = (Button) findViewById(R.id.btnAlarm);
        btnAlarm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent iAlarmReceiver = new Intent(arg0.getContext(), AlarmReceiver.class);
				PendingIntent piBroadcast = PendingIntent.getBroadcast(arg0.getContext(), (int) Math.random(), iAlarmReceiver, 0);
				
				AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
				am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(1000*5), piBroadcast);
				Toast.makeText(arg0.getContext(), "Alam will set after 5 seconds", Toast.LENGTH_LONG).show();
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
