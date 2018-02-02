package com.tencent.mm.plugin.card.a;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.card.a.i.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class i$a$2 extends BroadcastReceiver {
    final /* synthetic */ a kJq;

    i$a$2(a aVar) {
        this.kJq = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            x.i("MicroMsg.CardLbsOrBluetooth", "Receive intent failed");
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            int state = defaultAdapter.getState();
            x.d("MicroMsg.CardLbsOrBluetooth", "state:%d", Integer.valueOf(state));
            if (state == 12) {
                this.kJq.kJl = true;
                ag.h(this.kJq.kJo, this.kJq.kJn);
            } else if (state == 10) {
                ag.K(this.kJq.kJo);
                this.kJq.kJl = false;
                this.kJq.kJm.clear();
            }
        }
    }
}
