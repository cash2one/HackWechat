package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.b.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import java.util.HashMap;

public final class b implements ap {
    private static b svN = null;
    private a svO = new a();
    private d svP = new d();
    private c svQ = new c();
    private com.tencent.mm.plugin.voip_cs.a.a svR = new com.tencent.mm.plugin.voip_cs.a.a();
    private c svS = new 1(this);

    private static b bIR() {
        if (svN == null) {
            svN = new b();
            ar.Ha().a("plugin.voip_cs", svN);
        }
        return svN;
    }

    public static a bIS() {
        return bIR().svO;
    }

    public static d bIT() {
        g.Dh().Ct();
        if (bIR().svP == null) {
            bIR().svP = new d();
        }
        return bIR().svP;
    }

    public static c bIU() {
        return bIR().svQ;
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x.d("MicroMsg.SubCoreVoipCS", "now account reset!");
        com.tencent.mm.sdk.b.a.xef.b(this.svR);
        com.tencent.mm.sdk.b.a.xef.b(this.svS);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xef.c(this.svR);
        com.tencent.mm.sdk.b.a.xef.c(this.svS);
    }
}
