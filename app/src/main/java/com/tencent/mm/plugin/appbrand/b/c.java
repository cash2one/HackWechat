package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.sdk.d.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c extends h {
    final String TAG;
    final d iHa;
    final a iHb;
    final e iHc;
    final c iHd;
    final b iHe;
    public final AtomicBoolean iHf;
    private final AtomicBoolean iHg;
    private final AtomicReference<com.tencent.mm.sdk.d.c> iHh;
    private final AtomicReference<com.tencent.mm.sdk.d.c> iHi;
    final e irP;

    static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] iGZ = new int[a.values().length];

        static {
            try {
                iGZ[a.iGQ.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iGZ[a.iGS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iGZ[a.iGT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iGZ[a.iGR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    abstract void aar();

    public abstract void b(a aVar);

    static /* synthetic */ void a(c cVar, com.tencent.mm.sdk.d.c cVar2) {
        cVar.iHg.set(false);
        cVar.iHh.set(cVar2);
        cVar.iHi.set(null);
        super.b(cVar2);
    }

    c(e eVar) {
        super("MicroMsg.AppBrand.AppRunningStateMachine[" + eVar.mAppId + "]", eVar.Yz() ? new ag("AppRunningStateMachineForGameRuntime").oAt.getLooper() : Looper.getMainLooper());
        this.iHf = new AtomicBoolean(false);
        this.iHg = new AtomicBoolean(false);
        this.iHh = new AtomicReference(null);
        this.iHi = new AtomicReference(null);
        this.TAG = this.mName;
        this.irP = eVar;
        this.iHd = new c(this, this);
        this.iHe = new b(this, this);
        this.iHb = new a(this, this, eVar);
        this.iHa = new d(this, this);
        this.iHc = new e(this, this);
        Runnable 1 = new 1(this);
        if (Looper.myLooper() == this.xiR.getLooper()) {
            1.run();
            return;
        }
        this.iHg.set(true);
        this.xiR.post(1);
    }

    public final void start() {
        if (!this.iHf.get()) {
            if (Looper.myLooper() == this.xiR.getLooper()) {
                super.start();
            } else {
                this.xiR.post(new 2(this));
            }
        }
    }

    final void a(g gVar) {
        this.iHh.set(null);
        this.iHi.set(gVar);
        Message cgG = cgG();
        if (cgG == null || cgG.what != -2) {
            b(a((a) gVar));
        }
    }

    public final a aas() {
        if (!this.iHg.get() || Thread.currentThread().getId() == this.xiR.getLooper().getThread().getId()) {
            return aat();
        }
        if (!ag.isMainThread()) {
            return (a) new 3(this).b(new af(this.xiR.getLooper()));
        }
        a aVar = (com.tencent.mm.sdk.d.c) this.iHi.get();
        x.i(this.TAG, "getRunningStateExport, pending change in sm-looper(%d) but query from main-looper, cached-state=%s, stopped=%b", new Object[]{Long.valueOf(this.xiR.getLooper().getThread().getId()), aVar, Boolean.valueOf(this.iHf.get())});
        if (aVar != null) {
            return a(aVar);
        }
        return r1 ? a.iGT : a.iGQ;
    }

    private a aat() {
        if (this.iHf.get()) {
            return a.iGT;
        }
        a aVar = (com.tencent.mm.sdk.d.c) this.iHh.get();
        if (aVar != null) {
            return a(aVar);
        }
        aVar = (com.tencent.mm.sdk.d.c) this.iHi.get();
        if (aVar != null) {
            return a(aVar);
        }
        if (Thread.currentThread().getId() != this.xiR.getLooper().getThread().getId()) {
            aVar = (a) new bc<a>(this) {
                final /* synthetic */ c iHj;

                {
                    this.iHj = r1;
                }

                protected final /* synthetic */ Object run() {
                    return super.cgH();
                }
            }.b(new af(this.xiR.getLooper()));
        } else {
            aVar = super.cgH();
        }
        return a(aVar);
    }

    private a a(a aVar) {
        if (aVar == this.iHb || aVar == this.iHd || aVar == this.iHe) {
            return a.iGR;
        }
        if (aVar == this.iHc) {
            return a.iGS;
        }
        if (aVar == this.iHa) {
            return a.iGQ;
        }
        return a.iGQ;
    }

    public final void jz(int i) {
        this.iHg.set(true);
        if (cgG() == null) {
            super.Dh(i);
        } else {
            super.Di(i);
        }
    }

    protected final boolean h(Message message) {
        return message.what != 1000;
    }

    protected final void i(Message message) {
        super.i(message);
        this.iHg.set(false);
    }

    protected final void ZF() {
        super.ZF();
        if (this.xiR.getLooper().getThread().getId() != Looper.getMainLooper().getThread().getId()) {
            this.xiR.post(new 6(this));
        }
    }
}
