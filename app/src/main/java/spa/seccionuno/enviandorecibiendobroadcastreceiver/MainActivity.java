package spa.seccionuno.enviandorecibiendobroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    BroadcastReceiver miReceptor;
    IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miReceptor=new MiBroadCastReceiver();
        intentFilter=new IntentFilter("MI_ESPECIFICA_ACTION");
    }

    @Override
    public void onResume(){
        super.onResume();

        registerReceiver(miReceptor,intentFilter);
    }

    public void onClick(View view){
        Intent i= new Intent("MI_ESPECIFICA_ACTION");
        i.putExtra("clave", "algun valor del Intent");
        sendBroadcast(i);
    }

    @Override
    public void onPause(){
        super.onPause();

        unregisterReceiver(miReceptor);
    }

    public class MiBroadCastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context,Intent i){
            Toast.makeText(context,"Emision recepcionada en MiBroadCastReceiver, " +
            "valor reibido: " + i.getStringExtra("clave"),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
