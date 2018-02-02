package com.tencent.mm.plugin.g.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    final a kAi;
    public final BroadcastReceiver kAj = new BroadcastReceiver(this) {
        final /* synthetic */ a kAk;

        {
            this.kAk = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent == null) {
                x.e("McroMsg.exdevice.BluetoohtStateMonitor", "null == intent");
            } else if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                x.i("McroMsg.exdevice.BluetoohtStateMonitor", "onReceive, action = " + intent.getAction());
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (10 == intExtra || 12 == intExtra) {
                    this.kAk.kAi.nf(intExtra);
                }
            }
        }
    };

    public a(a aVar) {
        x.i("McroMsg.exdevice.BluetoohtStateMonitor", "register BluetoothState receiver");
        this.kAi = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        ac.getContext().registerReceiver(this.kAj, intentFilter);
    }
}
