package com.tencent.mm.z;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class p implements com.tencent.mm.kernel.api.a, c, f, h, com.tencent.mm.kernel.b.c {
    private static ConcurrentHashMap<String, p> hfi = new ConcurrentHashMap();
    private volatile a hfe;
    private volatile Class<? extends ap> hff;
    private volatile ap hfg;
    private volatile boolean hfh = false;

    public interface a {
        ap createSubCore();
    }

    public p(Class<? extends ap> cls) {
        this.hff = cls;
        a(this.hff.getName(), this);
    }

    public p(a aVar) {
        this.hfe = aVar;
    }

    public final synchronized ap FP() {
        if (this.hfg == null) {
            a(createSubCore());
        }
        return this.hfg;
    }

    public final void a(ap apVar) {
        synchronized (this) {
            this.hfg = apVar;
            if (this.hff == null && this.hfg != null) {
                this.hff = this.hfg.getClass();
            }
        }
    }

    private ap createSubCore() {
        try {
            x.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", this.hff, this.hfe);
            if (this.hfe != null) {
                return this.hfe.createSubCore();
            }
            return (ap) this.hff.newInstance();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CompatSubCore", e, "", new Object[0]);
            throw new IllegalAccessError(e.getMessage());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.CompatSubCore", e2, "", new Object[0]);
            throw new IllegalAccessError(e2.getMessage());
        }
    }

    private synchronized void reset() {
        this.hfg = null;
        this.hfh = false;
    }

    public static p a(String str, p pVar) {
        p pVar2 = (p) hfi.putIfAbsent(str, pVar);
        if (pVar2 == null) {
            com.tencent.mm.kernel.a.c Dt = com.tencent.mm.kernel.a.c.Dt();
            x.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", pVar);
            Dt.gRB.putIfAbsent(pVar, Dt.gRB);
        } else {
            pVar = pVar2;
        }
        x.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s", str, pVar);
        return pVar;
    }

    public static p gq(String str) {
        p pVar = (p) hfi.get(str);
        if (pVar == null) {
            x.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", str);
        } else {
            com.tencent.mm.kernel.a.c.Dt().aD(pVar);
        }
        return pVar;
    }

    public static void FQ() {
        for (p reset : hfi.values()) {
            reset.reset();
        }
    }

    public static void gK(int i) {
        for (p FP : hfi.values()) {
            ap FP2 = FP.FP();
            if (FP2 != null) {
                FP2.gd(i);
            }
        }
    }

    public static <T extends ap> T s(Class<T> cls) {
        p gq = gq(cls.getName());
        if (gq == null) {
            gq = new p((Class) cls);
            a(cls.getName(), gq);
        }
        return gq.FP();
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        ap FP = FP();
        if (FP == null) {
            return null;
        }
        return FP.Bn();
    }

    public void onAccountInitialized(e.c cVar) {
        ap FP = FP();
        if (FP != null) {
            FP.bq(cVar.gQA);
            this.hfh = true;
        }
    }

    public void onAccountRelease() {
        ap FP = FP();
        if (FP != null) {
            FP.onAccountRelease();
        }
    }

    public final void Dp() {
        ap FP = FP();
        if (FP != null && this.hfh) {
            FP.br(com.tencent.mm.compatible.util.f.ze());
        }
    }

    public void fN(String str) {
    }

    public final void Dq() {
        FP();
    }

    public String toString() {
        return super.toString() + " " + this.hff + " " + this.hfe + " " + this.hfg;
    }
}
