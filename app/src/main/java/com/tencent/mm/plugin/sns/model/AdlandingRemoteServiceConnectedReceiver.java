package com.tencent.mm.plugin.sns.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;

public class AdlandingRemoteServiceConnectedReceiver extends BroadcastReceiver {
    private Runnable hXj;

    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.tencnet.mm.action.adlanding.connected".equals(intent.getAction()) && this.hXj != null) {
            this.hXj.run();
        }
    }

    public static void b(d dVar) {
        dVar.a(new Intent("com.tencnet.mm.action.adlanding.connected"));
    }
}
