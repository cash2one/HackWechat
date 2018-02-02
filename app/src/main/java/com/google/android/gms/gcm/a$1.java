package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class a$1 extends Handler {
    final /* synthetic */ a aQI;

    a$1(a aVar, Looper looper) {
        this.aQI = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message != null) {
            Object obj = message.obj;
        }
        Intent intent = (Intent) message.obj;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            a.a(this.aQI).add(intent);
        } else if (!a.a(this.aQI, intent)) {
            intent.setPackage(a.b(this.aQI).getPackageName());
            a.b(this.aQI).sendBroadcast(intent);
        }
    }
}
