package com.tencent.mm.vending.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.vending.h.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public abstract class a implements b {
    Context mContext;
    private c zAR = new c();
    public c<Vending> zAS = new c();
    Map<Class, a> zAT = new ConcurrentHashMap();
    byte[] zAU = new byte[0];
    com.tencent.mm.vending.base.a<Object> zAV = new 1(this);
    private AtomicBoolean zAW = new AtomicBoolean(false);
    boolean zAX = false;
    Map<Class, com.tencent.mm.vending.b.c<b>> zAY = new HashMap();
    public com.tencent.mm.vending.d.a zAZ;

    public a() {
        this.zAS.keep(this.zAV);
        this.zAV.addVendingDataResolvedCallback(new 2(this));
    }

    public void keep(com.tencent.mm.vending.e.a aVar) {
        Assert.assertTrue("target must be a ILifeCycle", aVar instanceof com.tencent.mm.vending.e.a);
        this.zAR.keep(aVar);
    }

    public final <_Struct> void a(Class<_Struct> cls, b<_Struct> bVar) {
        com.tencent.mm.vending.b.c cVar = (com.tencent.mm.vending.b.c) this.zAY.get(cls);
        if (cVar == null) {
            cVar = new 3(this, d.zCO);
            this.zAY.put(cls, cVar);
        }
        cVar.aE(bVar);
        Object peek = this.zAV.peek(cls);
        if (peek != null) {
            bVar.aX(peek);
        }
    }

    public final <_Struct> _Struct J(Class<_Struct> cls) {
        czF();
        if (Looper.myLooper() == Looper.getMainLooper() && !this.zAX) {
            synchronized (this.zAU) {
                if (!this.zAX) {
                    try {
                        this.zAU.wait();
                    } catch (Throwable e) {
                        com.tencent.mm.vending.f.a.printErrStackTrace("Vending.Interactor", e, "", new Object[0]);
                    }
                }
            }
        }
        return this.zAV.get(cls);
    }

    public final void K(Class<?> cls) {
        czF();
        this.zAV.request(cls);
    }

    public final <_Struct> void a(Class<_Struct> cls, a<_Struct> aVar) {
        czF();
        this.zAT.put(cls, aVar);
    }

    private void czF() {
        if (Looper.myLooper() == this.zAV.getLooper() && !this.zAW.get()) {
            com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[]{this});
        }
    }

    public void onCreate() {
        this.zAW.set(true);
    }

    public void onDestroy() {
        this.zAR.dead();
        this.zAS.dead();
    }
}
