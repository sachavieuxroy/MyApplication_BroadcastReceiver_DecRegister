package google.android.com.myapplication_broadcastreceiver_decregister;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
public class MainActivity extends Activity {
    ComponentName monReceiver;
    PackageManager pm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monReceiver=new ComponentName(this,MySmsReceiver.class);
        pm=getPackageManager();
    }


    @Override
    protected void onResume() {
        super.onResume();
        pm.setComponentEnabledSetting(monReceiver,PackageManager.COMPONENT_ENABLED_STATE_ENABLED,PackageManager.DONT_KILL_APP);
    }

    @Override
    protected void onPause() {
        super.onPause();

        pm.setComponentEnabledSetting(monReceiver,PackageManager.COMPONENT_ENABLED_STATE_DISABLED,PackageManager.DONT_KILL_APP);
    }
}
