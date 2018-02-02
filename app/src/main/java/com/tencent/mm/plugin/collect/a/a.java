package com.tencent.mm.plugin.collect.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.by.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.mm.plugin.collect.b.g;
import com.tencent.mm.plugin.collect.b.o;
import com.tencent.mm.plugin.collect.b.u;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.c.asa;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import com.tencent.mm.z.q;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a implements ap {
    private com.tencent.mm.z.bs.a lhZ = new 1(this);
    private g lia = new g();
    private u lib = new u();

    public static a ayE() {
        return (a) p.s(a.class);
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("paymsg", this.lhZ, true);
        e eVar = this.lia;
        eVar.ceO();
        eVar.lin = new ConcurrentLinkedQueue();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(1384, eVar);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(1317, eVar);
        this.lib.ceO();
    }

    public final void onAccountRelease() {
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("paymsg", this.lhZ, true);
        e eVar = this.lia;
        eVar.dead();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(1384, eVar);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.b(1317, eVar);
        g.ayK();
        this.lib.dead();
    }

    public static com.tencent.mm.plugin.collect.b.d ayF() {
        com.tencent.mm.kernel.g.Dh().Ct();
        return com.tencent.mm.plugin.collect.b.d.lih;
    }

    public static boolean ayG() {
        String str = (String) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xtD, "");
        long FX = q.FX();
        if (bh.ov(str) || str.equals("in.caf")) {
            return (FX & 32768) != 0;
        } else {
            x.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
            com.tencent.mm.kernel.g.Dj().CU().set(147457, Long.valueOf(FX | 32768));
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_asa = new asa();
            com_tencent_mm_protocal_c_asa.pQk = 1;
            ((h) com.tencent.mm.kernel.g.h(h.class)).EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(c.CTRL_INDEX, com_tencent_mm_protocal_c_asa));
            return true;
        }
    }

    public final void ayH() {
        xr("cash.caf");
        com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xtD, "cash.caf");
    }

    public final void ayI() {
        xr("in.caf");
        com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xtD, "in.caf");
    }

    private void xr(String str) {
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(304, new 2(this));
        k oVar = new o(bh.az(str, ""));
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().gPJ.a(oVar, 0);
    }
}
