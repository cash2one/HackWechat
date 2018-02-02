package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class l implements Callback {
    public final Object aNX = new Object();
    public final a aOp;
    public final ArrayList<b> aOq = new ArrayList();
    public final ArrayList<b> aOr = new ArrayList();
    public final ArrayList<c> aOs = new ArrayList();
    public volatile boolean aOt = false;
    public final AtomicInteger aOu = new AtomicInteger(0);
    public boolean aOv = false;
    public final Handler mHandler;

    public l(Looper looper, a aVar) {
        this.aOp = aVar;
        this.mHandler = new Handler(looper, this);
    }

    public final void a(b bVar) {
        w.ag(bVar);
        synchronized (this.aNX) {
            if (this.aOq.contains(bVar)) {
                new StringBuilder("registerConnectionCallbacks(): listener ").append(bVar).append(" is already registered");
            } else {
                this.aOq.add(bVar);
            }
        }
        if (this.aOp.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, bVar));
        }
    }

    public final void a(c cVar) {
        w.ag(cVar);
        synchronized (this.aNX) {
            if (this.aOs.contains(cVar)) {
                new StringBuilder("registerConnectionFailedListener(): listener ").append(cVar).append(" is already registered");
            } else {
                this.aOs.add(cVar);
            }
        }
    }

    public final void do(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            z = true;
        }
        w.d(z, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.aNX) {
            this.aOv = true;
            ArrayList arrayList = new ArrayList(this.aOq);
            int i2 = this.aOu.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (this.aOt && this.aOu.get() == i2) {
                    if (this.aOq.contains(bVar)) {
                        bVar.dh(i);
                    }
                }
            }
            this.aOr.clear();
            this.aOv = false;
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            b bVar = (b) message.obj;
            synchronized (this.aNX) {
                if (this.aOt && this.aOp.isConnected() && this.aOq.contains(bVar)) {
                    bVar.e(null);
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        return false;
    }

    public final void oO() {
        this.aOt = false;
        this.aOu.incrementAndGet();
    }
}
