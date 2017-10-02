package spa.seccionuno.enviandorecibiendobroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by USUARIO on 05/07/2015.
 */
public class MiSegudaBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context,Intent i){
        Toast.makeText(context, "Emision recepcionada en MiSegundaBroadCastReceiver, " +
                "valor reibido: " + i.getStringExtra("clave"), Toast.LENGTH_LONG).show();
    }
}
