package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.a;
import java.io.IOException;

public class InstanceIDListenerService extends Service {
    static String ACTION = "action";
    private static String aQx = "gcm.googleapis.com/refresh";
    private static String aRb = "google.com/iid";
    private static String aRc = "CMD";
    MessengerCompat aQZ = new MessengerCompat(new 1(this, Looper.getMainLooper()));
    BroadcastReceiver aRa = new 2(this);
    int aRd;
    int aRe;

    static void N(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(aRc, "SYNC");
        context.startService(intent);
    }

    static void a(Context context, e eVar) {
        eVar.pu();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(aRc, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    static /* synthetic */ void a(InstanceIDListenerService instanceIDListenerService, Message message, int i) {
        d.O(instanceIDListenerService);
        instanceIDListenerService.getPackageManager();
        if (i == d.aRl || i == d.aRk) {
            instanceIDListenerService.e((Intent) message.obj);
        } else {
            new StringBuilder("Message from unexpected caller ").append(i).append(" mine=").append(d.aRk).append(" appid=").append(d.aRl);
        }
    }

    public final void e(Intent intent) {
        a M;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            M = a.M(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            M = a.a(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(aRc);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                new StringBuilder("Service command ").append(stringExtra).append(" ").append(stringExtra2).append(" ").append(intent.getExtras());
            }
            if (intent.getStringExtra("unregistered") != null) {
                a.pp().aU(stringExtra == null ? "" : stringExtra);
                a.pq().h(intent);
                return;
            } else if (aQx.equals(intent.getStringExtra("from"))) {
                a.pp().aU(stringExtra);
                return;
            } else if ("RST".equals(stringExtra2)) {
                M.aQX = 0;
                a.aQT.aT(M.aQW + "|");
                M.aQV = null;
                return;
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!a.pp().isEmpty()) {
                    a.pp().pu();
                    return;
                }
                return;
            } else if ("SYNC".equals(stringExtra2)) {
                a.pp().aU(stringExtra);
                return;
            } else if ("PING".equals(stringExtra2)) {
                try {
                    a.J(this).a(aRb, d.pt(), intent.getExtras());
                    return;
                } catch (IOException e) {
                    return;
                }
            } else {
                return;
            }
        }
        if (Log.isLoggable("InstanceID", 3)) {
            a.pq().h(intent);
        } else {
            a.pq().h(intent);
        }
    }

    public IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) ? null : this.aQZ.getBinder();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.aRa, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.aRa);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this) {
            this.aRd++;
            if (i2 > this.aRe) {
                this.aRe = i2;
            }
        }
        if (intent == null) {
            stop();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (VERSION.SDK_INT <= 18) {
                    Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                    if (intent2 != null) {
                        startService(intent2);
                        return 1;
                    }
                }
                e(intent);
            }
            stop();
            if (intent.getStringExtra("from") != null) {
                GcmReceiver.b(intent);
            }
            return 2;
        } finally {
            stop();
        }
    }

    final void stop() {
        synchronized (this) {
            this.aRd--;
            if (this.aRd == 0) {
                stopSelf(this.aRe);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                new StringBuilder("Stop ").append(this.aRd).append(" ").append(this.aRe);
            }
        }
    }
}
