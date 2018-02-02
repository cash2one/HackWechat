package com.tencent.mm.plugin.appbrand.q.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class b$a extends BroadcastReceiver {
    final /* synthetic */ b jSD;

    private b$a(b bVar) {
        this.jSD = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        synchronized (this.jSD.jSB) {
            this.jSD.jSA = intent;
        }
    }
}
