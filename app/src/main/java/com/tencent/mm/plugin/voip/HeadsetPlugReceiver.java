package com.tencent.mm.plugin.voip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.x;

public class HeadsetPlugReceiver extends BroadcastReceiver {
    private a siH = null;

    public void onReceive(Context context, Intent intent) {
        x.d("MicroMsg.HeadsetPlugReceiver", "headset onReceive %s  %d", new Object[]{intent.getAction(), Integer.valueOf(intent.getIntExtra("state", 0))});
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            if (intent.getIntExtra("state", 0) == 0) {
                if (this.siH != null) {
                    this.siH.fY(false);
                }
            } else if (intent.getIntExtra("state", 0) == 1 && this.siH != null) {
                this.siH.fY(true);
            }
        }
    }

    public final void a(Context context, a aVar) {
        this.siH = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(this, intentFilter);
    }

    public final void dA(Context context) {
        try {
            context.unregisterReceiver(this);
        } catch (Exception e) {
            x.e("MicroMsg.HeadsetPlugReceiver", "unregisterReceiver(HeadsetPlugReceiver.this) error:%s", new Object[]{e.getMessage()});
        }
        this.siH = null;
    }
}
