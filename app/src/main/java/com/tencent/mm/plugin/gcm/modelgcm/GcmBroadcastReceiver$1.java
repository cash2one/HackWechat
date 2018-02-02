package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.x;

class GcmBroadcastReceiver$1 implements Runnable {
    final /* synthetic */ a nyh;
    final /* synthetic */ GcmBroadcastReceiver nyi;

    GcmBroadcastReceiver$1(GcmBroadcastReceiver gcmBroadcastReceiver, a aVar) {
        this.nyi = gcmBroadcastReceiver;
        this.nyh = aVar;
    }

    public final void run() {
        x.i("GcmBroadcastReceiver", "Gcm push isRegistrationExpired reNewalRegistting start ");
        d.pPH.a(452, 43, 1, false);
        this.nyh.aSc();
    }
}
