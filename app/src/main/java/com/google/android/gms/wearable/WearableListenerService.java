package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.e;
import com.google.android.gms.common.k;
import com.google.android.gms.wearable.c.b;
import com.google.android.gms.wearable.k.a;
import com.google.android.gms.wearable.n.c;

public abstract class WearableListenerService extends Service implements a$a, b$a, b, a, n.b, c {
    private boolean aFS;
    private IBinder aMY;
    private volatile int bdE = -1;
    private String bdF;
    private Handler bdG;
    private Object bdH = new Object();

    static /* synthetic */ void b(WearableListenerService wearableListenerService) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == wearableListenerService.bdE) {
            return;
        }
        if (e.a(wearableListenerService, callingUid, "com.google.android.wearable.app.cn")) {
            if (k.po().a(wearableListenerService.getPackageManager(), "com.google.android.wearable.app.cn")) {
                wearableListenerService.bdE = callingUid;
                return;
            }
            throw new SecurityException("Caller is not Android Wear.");
        } else if (e.m(wearableListenerService, callingUid)) {
            wearableListenerService.bdE = callingUid;
        } else {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public void a(Channel channel) {
    }

    public void a(Channel channel, int i, int i2) {
    }

    public void a(e eVar) {
    }

    public void a(l lVar) {
    }

    public void a(m mVar) {
    }

    public void b(Channel channel, int i, int i2) {
    }

    public void b(m mVar) {
    }

    public void c(Channel channel, int i, int i2) {
    }

    public final IBinder onBind(Intent intent) {
        return "com.google.android.gms.wearable.BIND_LISTENER".equals(intent.getAction()) ? this.aMY : null;
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onCreate: ").append(getPackageName());
        }
        this.bdF = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.bdG = new Handler(handlerThread.getLooper());
        this.aMY = new a(this);
    }

    public void onDestroy() {
        synchronized (this.bdH) {
            this.aFS = true;
            if (this.bdG == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.bdG.getLooper().quit();
        }
        super.onDestroy();
    }
}
