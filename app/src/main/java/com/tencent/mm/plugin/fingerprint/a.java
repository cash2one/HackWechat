package com.tencent.mm.plugin.fingerprint;

import com.tencent.mm.by.h.d;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.plugin.fingerprint.b.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.fingerprint.b.j;
import com.tencent.mm.plugin.fingerprint.b.k;
import com.tencent.mm.plugin.fingerprint.b.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import java.util.HashMap;

public class a implements ap {
    private n myP = new n();
    private i myQ = new i();
    private j myR = new j();
    private b myS = new b();
    private f myT = new f();
    private g myU = new g();
    private c myV;

    static {
        com.tencent.mm.wallet_core.a.i("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
    }

    public static a aJS() {
        return (a) p.s(a.class);
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.SubCoreFingerPrint", "alvinluo SoterWrapperApi isInit: %b in SubCoreFingerprint initTA", new Object[]{Boolean.valueOf(com.tencent.d.b.b.a.cFX().isInit())});
        if (com.tencent.d.b.b.a.cFX().isInit()) {
            aJU();
        } else {
            x.i("MicroMsg.SubCoreFingerPrint", "alvinluo soter is not initialized, do init");
            com.tencent.mm.kernel.g.a(l.class, new com.tencent.mm.plugin.fingerprint.b.d());
            com.tencent.mm.kernel.g.Dm().g(new 1(this), 1500);
        }
        com.tencent.mm.sdk.b.a.xef.b(this.myP);
        com.tencent.mm.sdk.b.a.xef.b(this.myQ);
        com.tencent.mm.sdk.b.a.xef.b(this.myR);
        com.tencent.mm.sdk.b.a.xef.b(this.myS);
        com.tencent.mm.sdk.b.a.xef.b(this.myT);
        com.tencent.mm.sdk.b.a.xef.b(this.myU);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xef.c(this.myP);
        this.myQ.release();
        com.tencent.mm.sdk.b.a.xef.c(this.myQ);
        com.tencent.mm.sdk.b.a.xef.c(this.myR);
        com.tencent.mm.sdk.b.a.xef.c(this.myS);
        com.tencent.mm.sdk.b.a.xef.c(this.myT);
        if (this.myV != null) {
            c.abort();
            c.release();
            this.myV = null;
        }
        com.tencent.mm.sdk.b.a.xef.c(this.myU);
    }

    public static c aJT() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (aJS().myV == null) {
            aJS().myV = new c();
        }
        return aJS().myV;
    }

    private static void aJU() {
        com.tencent.mm.kernel.c.a kVar;
        if (com.tencent.d.b.a.cFW()) {
            kVar = new k();
        } else {
            kVar = new com.tencent.mm.plugin.fingerprint.b.d();
        }
        kVar.aKf();
        com.tencent.mm.kernel.g.a(l.class, kVar);
    }
}
