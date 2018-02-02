package com.tencent.mm.plugin.voip.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.sdk.platformtools.ac;

class j$1 extends BroadcastReceiver {
    final /* synthetic */ j smu;

    j$1(j jVar) {
        this.smu = jVar;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        PowerManager powerManager = (PowerManager) ac.getContext().getSystemService("power");
        if ("android.intent.action.USER_PRESENT".equals(action) && powerManager.isScreenOn()) {
            j.a(this.smu, false);
        } else if ("android.intent.action.SCREEN_ON".equals(action)) {
            j.a(this.smu, false);
        } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
            j.a(this.smu, true);
            if (!b.yS(j.a(this.smu).mState) && !j.b(this.smu)) {
                d.bGj().stopRing();
            }
        }
    }
}
