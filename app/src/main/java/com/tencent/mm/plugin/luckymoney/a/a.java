package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.mm.by.h;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.th;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.luckymoney.b.b;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import java.io.File;
import java.util.HashMap;

public class a implements ap {
    private com.tencent.mm.z.bs.a lhZ = new 1(this);
    private d nYK;
    private f nYL;
    private b nYM = new b();
    private ai nYN;
    private c<th> nYO = new 2(this);

    public static a aWP() {
        return (a) p.s(a.class);
    }

    public a() {
        File file = new File(aWR());
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(e.gHD);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public final HashMap<Integer, h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        t bYV = ao.bYV();
        if (g.Dh().Cy()) {
            com.tencent.mm.plugin.y.a.aRi().a(4, bYV);
            g.Dk();
            g.Di().gPJ.a(1060, bYV);
        }
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("paymsg", this.lhZ, true);
        boolean z2 = false;
        g.Dk();
        if (System.currentTimeMillis() - g.Dj().CU().Dm(352276) >= 43200000) {
            z2 = true;
        }
        x.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + z2 + ", isUpdate=" + z);
        if (z || z2) {
            x.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
            ao.bYV().ej(ac.getContext());
        }
        com.tencent.mm.sdk.b.a.xef.b(this.nYM);
        com.tencent.mm.sdk.b.a.xef.b(this.nYO);
        this.nYN = new ai();
    }

    public final void onAccountRelease() {
        ao bYV = ao.bYV();
        if (g.Dh().Cy()) {
            com.tencent.mm.plugin.y.a.aRi().b(4, bYV);
            g.Dk();
            g.Di().gPJ.b(1060, bYV);
            bYV.vfv = false;
            bYV.vfw = false;
        }
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("paymsg", this.lhZ, true);
        synchronized (this) {
            this.nYL = null;
        }
        com.tencent.mm.sdk.b.a.xef.c(this.nYM);
        com.tencent.mm.sdk.b.a.xef.c(this.nYO);
        if (this.nYN != null) {
            ai aiVar = this.nYN;
            com.tencent.mm.sdk.b.a.xef.c(aiVar.odL);
            if (aiVar.odI != null) {
                g.Dk();
                g.Di().gPJ.c(aiVar.odI);
                aiVar.odI = null;
            }
            if (aiVar.odJ != null) {
                g.Dk();
                g.Di().gPJ.c(aiVar.odJ);
                aiVar.odJ = null;
            }
        }
    }

    public static d aWQ() {
        g.Dh().Ct();
        if (aWP().nYK == null) {
            aWP().nYK = new d();
        }
        return aWP().nYK;
    }

    public static String aWR() {
        if (g.Dh().Cy()) {
            return com.tencent.mm.plugin.n.c.Fi() + "luckymoney";
        }
        return "";
    }

    public final synchronized f aWS() {
        if (this.nYL == null) {
            this.nYL = new f();
        }
        return this.nYL;
    }
}
