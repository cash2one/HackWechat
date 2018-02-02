package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.ae.d.c;
import com.tencent.mm.plugin.voip.a;
import com.tencent.mm.plugin.voip.ui.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.b;
import com.tencent.mm.z.bp;
import java.util.HashMap;

public final class d implements ap {
    private m sjv = null;
    private i sjw = new i();
    g sjx;
    private a sjy = new a();

    private static d bGi() {
        ar.Ha();
        d dVar = (d) bp.hY("plugin.voip");
        if (dVar != null) {
            return dVar;
        }
        Object dVar2 = new d();
        ar.Ha().a("plugin.voip", dVar2);
        return dVar2;
    }

    public static m bGj() {
        if (ar.Hj()) {
            if (bGi().sjv == null) {
                bGi().sjv = new m();
            }
            return bGi().sjv;
        }
        throw new b();
    }

    public static g bGk() {
        if (ar.Hj()) {
            if (bGi().sjx == null) {
                bGi().sjx = new g();
            }
            return bGi().sjx;
        }
        throw new b();
    }

    public final void onAccountRelease() {
        if (this.sjx != null) {
            ag.y(new 1(this));
        }
        c.b(Integer.valueOf(50), this.sjw);
        bGj();
        m.bHx();
        com.tencent.mm.sdk.b.a.xef.c(this.sjy);
    }

    public final HashMap<Integer, com.tencent.mm.by.h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        c.a(Integer.valueOf(50), this.sjw);
        bGj();
        m.bHw();
        com.tencent.mm.sdk.b.a.xef.b(this.sjy);
        ar.getNotification().cancel(40);
        ar.Hg();
        boolean booleanValue = ((Boolean) com.tencent.mm.z.c.CU().get(73217, Boolean.valueOf(true))).booleanValue();
        ar.Hg();
        boolean booleanValue2 = ((Boolean) com.tencent.mm.z.c.CU().get(73218, Boolean.valueOf(true))).booleanValue();
        boolean zr = com.tencent.mm.k.a.zr();
        ar.Hg();
        x.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", new Object[]{Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2), Boolean.valueOf(zr), Boolean.valueOf(((Boolean) com.tencent.mm.z.c.CU().get(w.a.xxO, Boolean.valueOf(false))).booleanValue())});
        if (!((Boolean) com.tencent.mm.z.c.CU().get(w.a.xxO, Boolean.valueOf(false))).booleanValue()) {
            boolean z2 = booleanValue || booleanValue2;
            if (z2 != zr) {
                if (z2 && !zr) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(500, 13, 1, false);
                } else if (!z2 && zr) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(500, 14, 1, false);
                }
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xxO, Boolean.valueOf(true));
        }
    }

    public final void br(boolean z) {
    }
}
