package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.pluginsdk.i.a.d.p;
import com.tencent.mm.pluginsdk.i.a.d.s;
import com.tencent.mm.pluginsdk.model.b;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ab;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.util.HashMap;

public class an implements ap {
    private static HashMap<Integer, d> gwY;
    private o vfm;
    private am$a vfn = null;
    private j vfo = new j();
    private b vfp = new b();
    private final s vfq = new s();
    private c vfr = new 3(this);
    private c vfs = new 4(this);

    private static an bYQ() {
        ar.Ha();
        an anVar = (an) bp.hY(an.class.getName());
        if (anVar == null) {
            return new an();
        }
        return anVar;
    }

    public static j bYR() {
        return bYQ().vfo;
    }

    public static c aqd() {
        return a.aqd();
    }

    public static e bil() {
        return a.bil();
    }

    public static h bim() {
        return a.bim();
    }

    public static i bin() {
        return a.bin();
    }

    public static k bYS() {
        return a.bio();
    }

    public static o bYT() {
        g.Dh().Ct();
        if (bYQ().vfm == null) {
            an bYQ = bYQ();
            ar.Hg();
            bYQ.vfm = new o(com.tencent.mm.z.c.EV());
        }
        return bYQ().vfm;
    }

    public static am$a bYU() {
        g.Dh().Ct();
        if (bYQ().vfn == null) {
            bYQ().vfn = new am$a();
        }
        return bYQ().vfn;
    }

    public static m bip() {
        return a.bip();
    }

    public static d aRi() {
        return a.aRi();
    }

    public final void onAccountRelease() {
        am$a com_tencent_mm_pluginsdk_model_app_am_a = bYQ().vfn;
        if (com_tencent_mm_pluginsdk_model_app_am_a != null) {
            com_tencent_mm_pluginsdk_model_app_am_a.flT = 0;
        }
        com.tencent.mm.ae.d.c.b(Integer.valueOf(47), this.vfp);
        com.tencent.mm.ae.d.c.b(Integer.valueOf(49), this.vfo);
        com.tencent.mm.sdk.b.a.xef.c(this.vfr);
        com.tencent.mm.sdk.b.a.xef.c(this.vfs);
        k.bYq();
        s sVar = this.vfq;
        g.Di().b(sVar.vie);
        com.tencent.mm.sdk.b.a.xef.c(sVar.vif);
        for (com.tencent.mm.pluginsdk.i.a.d.g onAccountRelease : p.bZD()) {
            onAccountRelease.onAccountRelease();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return k.gJN;
            }
        });
        gwY.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new 2());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        ab.a.hfJ = a.bim();
        com.tencent.mm.ae.d.c.a(Integer.valueOf(47), this.vfp);
        com.tencent.mm.ae.d.c.a(Integer.valueOf(49), this.vfo);
        com.tencent.mm.sdk.b.a.xef.b(this.vfr);
        com.tencent.mm.sdk.b.a.xef.b(this.vfs);
        SightVideoJNI.registerALL();
        s sVar = this.vfq;
        for (com.tencent.mm.pluginsdk.i.a.d.g bRs : p.bZD()) {
            bRs.bRs();
        }
        g.Di().a(sVar.vie);
        com.tencent.mm.sdk.b.a.xef.b(sVar.vif);
    }

    public final void br(boolean z) {
    }
}
