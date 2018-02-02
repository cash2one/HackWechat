package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class c {
    private static final c a = new c();
    private ConcurrentHashMap<Integer, WeakReference<e>> b = new ConcurrentHashMap();
    private PhoneStateListener c = null;
    private Context d;

    public static c a() {
        return a;
    }

    private c() {
    }

    public synchronized void a(e eVar) {
        if (eVar != null) {
            this.b.put(Integer.valueOf(eVar.hashCode()), new WeakReference(eVar));
        }
    }

    public synchronized void b(e eVar) {
        if (eVar != null) {
            if (this.b.containsKey(Integer.valueOf(eVar.hashCode()))) {
                this.b.remove(Integer.valueOf(eVar.hashCode()));
            }
        }
    }

    private synchronized void a(int i) {
        Iterator it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            e eVar = (e) ((WeakReference) ((Entry) it.next()).getValue()).get();
            if (eVar != null) {
                eVar.a(i);
            } else {
                it.remove();
            }
        }
    }

    public void a(Context context) {
        if (this.c == null) {
            this.d = context.getApplicationContext();
            new Handler(Looper.getMainLooper()).post(new 1(this));
        }
    }

    protected void finalize() {
        super.finalize();
        if (this.c != null && this.d != null) {
            new Handler(Looper.getMainLooper()).post(new 2(this));
        }
    }
}
