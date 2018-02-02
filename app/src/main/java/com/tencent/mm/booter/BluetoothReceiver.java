package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.Set;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class BluetoothReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && !bh.ov(intent.getAction())) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                x.d("MicroMsg.BluetoothReceiver", "getDefaultAdapter == null");
                return;
            }
            Set bondedDevices = defaultAdapter.getBondedDevices();
            if (bondedDevices == null || bondedDevices.size() == 0) {
                x.d("MicroMsg.BluetoothReceiver", "getBondedDevices == null");
            } else if (!bh.ov(intent.getAction())) {
                x.d("MicroMsg.BluetoothReceiver", "dkbt action :" + intent.getAction());
                if (ar.Hj()) {
                    int intExtra;
                    try {
                        intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                    } catch (Throwable e) {
                        x.e("MicroMsg.BluetoothReceiver", "%s", new Object[]{bh.i(e)});
                        intExtra = 0;
                    }
                    x.d("MicroMsg.BluetoothReceiver", "dkbt  action :" + intent.getAction() + " state:" + intExtra + " isBluetoothScoOn :" + ar.Hh().xL() + " " + ar.Hh().xP());
                    if (intent.getAction().equalsIgnoreCase("android.media.SCO_AUDIO_STATE_CHANGED")) {
                        x.d("MicroMsg.BluetoothReceiver", "just STATE_CHANGED not real STATE_UPDATED" + intent.getAction());
                    } else if (intExtra == 1) {
                        x.d("MicroMsg.BluetoothReceiver", "sco connected!");
                        x.i("MicroMsg.MMAudioManager", "dkbt bluetoothStartSucc %s", new Object[]{ar.Hh().xP()});
                        f.gCh = true;
                        r0.fx(1);
                    } else if (intExtra == 0) {
                        x.d("MicroMsg.BluetoothReceiver", "sco disconnected!getStopBluetoothInBR = %s", new Object[]{Integer.valueOf(q.gGe.gED)});
                        if (q.gGe.gED == 1) {
                            ar.Hh().xJ();
                        }
                        ar.Hh().xH();
                    }
                }
            }
        }
    }
}
