package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.google.android.gms.iid.d;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    public static int aQA = 6500000;
    public static int aQB = 7000000;
    static a aQC;
    private static final AtomicInteger aQF = new AtomicInteger(1);
    public static int aQz = 5000000;
    private PendingIntent aQD;
    private Map<String, Handler> aQE = Collections.synchronizedMap(new HashMap());
    private final BlockingQueue<Intent> aQG = new LinkedBlockingQueue();
    final Messenger aQH = new Messenger(new 1(this, Looper.getMainLooper()));
    private Context context;

    public static synchronized a J(Context context) {
        a aVar;
        synchronized (a.class) {
            if (aQC == null) {
                aVar = new a();
                aQC = aVar;
                aVar.context = context.getApplicationContext();
            }
            aVar = aQC;
        }
        return aVar;
    }

    public static int K(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(d.O(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    static /* synthetic */ boolean a(a aVar, Intent intent) {
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) aVar.aQE.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                return handler.sendMessage(obtain);
            }
        }
        return false;
    }

    public static String c(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null ? "gcm" : stringExtra;
    }

    private synchronized void d(Intent intent) {
        if (this.aQD == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.aQD = PendingIntent.getBroadcast(this.context, 0, intent2, 0);
        }
        intent.putExtra("app", this.aQD);
    }

    @Deprecated
    private Intent g(Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        } else if (K(this.context) < 0) {
            throw new IOException("Google Play Services missing");
        } else {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(d.O(this.context));
            d(intent);
            intent.putExtra("google.message_id", "google.rpc" + String.valueOf(aQF.getAndIncrement()));
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.aQH);
            this.context.startService(intent);
            try {
                return (Intent) this.aQG.poll(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        d(intent);
        intent.setPackage(d.O(this.context));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(0));
        intent.putExtra("google.delay", Integer.toString(-1));
        if (d.O(this.context).contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    bundle2.putString("gcm." + str3, (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            com.google.android.gms.iid.a.M(this.context).b("GCM", "upstream", bundle2);
            return;
        }
        this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    @Deprecated
    public final synchronized String b(String... strArr) {
        String c;
        Object obj = null;
        synchronized (this) {
            String stringBuilder = new StringBuilder(strArr[0]).toString();
            Bundle bundle = new Bundle();
            if (d.O(this.context).contains(".gsf")) {
                bundle.putString("legacy.sender", stringBuilder);
                com.google.android.gms.iid.a M = com.google.android.gms.iid.a.M(this.context);
                String str = "GCM";
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    throw new IOException("MAIN_THREAD");
                }
                Object obj2 = 1;
                c = com.google.android.gms.iid.a.pr() ? null : com.google.android.gms.iid.a.aQT.c(M.aQW, stringBuilder, str);
                if (c == null) {
                    if (bundle.getString("ttl") != null) {
                        obj2 = null;
                    }
                    if (!"jwt".equals(bundle.getString(DownloadSettingTable$Columns.TYPE))) {
                        obj = obj2;
                    }
                    c = M.b(stringBuilder, str, bundle);
                    if (!(c == null || r0 == null)) {
                        com.google.android.gms.iid.a.aQT.a(M.aQW, stringBuilder, str, c, com.google.android.gms.iid.a.aQY);
                    }
                }
            } else {
                bundle.putString("sender", stringBuilder);
                Intent g = g(bundle);
                String str2 = "registration_id";
                if (g == null) {
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
                c = g.getStringExtra(str2);
                if (c == null) {
                    String stringExtra = g.getStringExtra("error");
                    if (stringExtra != null) {
                        throw new IOException(stringExtra);
                    }
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
            }
        }
        return c;
    }
}
