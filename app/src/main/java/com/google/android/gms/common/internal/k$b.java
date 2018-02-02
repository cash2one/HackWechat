package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class k$b extends Handler {
    final /* synthetic */ k aOk;

    public k$b(k kVar, Looper looper) {
        this.aOk = kVar;
        super(looper);
    }

    private static void e(Message message) {
        ((k$c) message.obj).unregister();
    }

    private static boolean f(Message message) {
        return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
    }

    public final void handleMessage(Message message) {
        PendingIntent pendingIntent = null;
        if (this.aOk.aOh.get() != message.arg1) {
            if (f(message)) {
                e(message);
            }
        } else if ((message.what == 1 || message.what == 5 || message.what == 6) && !this.aOk.isConnecting()) {
            e(message);
        } else if (message.what == 3) {
            if (message.obj instanceof PendingIntent) {
                pendingIntent = (PendingIntent) message.obj;
            }
            k.a(this.aOk).b(new ConnectionResult(message.arg2, pendingIntent));
            k.oH();
        } else if (message.what == 4) {
            k.a(this.aOk, 4);
            if (k.b(this.aOk) != null) {
                k.b(this.aOk).dh(message.arg2);
            }
            int i = message.arg2;
            k.oG();
            k.a(this.aOk, 4, 1, null);
        } else if (message.what == 2 && !this.aOk.isConnected()) {
            e(message);
        } else if (f(message)) {
            ((k$c) message.obj).oM();
        } else {
            Log.wtf("GmsClient", "Don't know how to handle this message.");
        }
    }
}
