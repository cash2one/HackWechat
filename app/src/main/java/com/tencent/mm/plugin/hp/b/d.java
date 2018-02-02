package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.be;
import com.tencent.mm.g.a.ck;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import java.util.HashMap;

public final class d implements ap {
    private final c<aw> lzV = new 1(this);
    boolean nAF = true;
    private final h nAG = new h();
    private final c<ck> nAH = new 2(this);
    private final f nAI = new f();
    private final c<be> nAJ = new 3(this);

    public final HashMap<Integer, com.tencent.mm.by.h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        b.a(new g(), new String[]{"//tinker"});
        ar.getSysCmdMsgExtension().a("checktinkerupdate", this.nAG, true);
        a.xef.b(this.lzV);
        this.nAH.ceO();
        a.xef.b(this.nAI);
        a.xef.b(this.nAJ);
        x.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
        g.cV(ac.getContext());
        try {
            ar.Hg();
            long longValue = ((Long) com.tencent.mm.z.c.CU().get(w.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue >= 3600000) {
                com.tinkerboots.sdk.a.cJn().oe(true);
                ar.Hg();
                com.tencent.mm.z.c.CU().a(w.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
                x.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(longValue));
            } else {
                com.tinkerboots.sdk.a.cJn().oe(false);
                x.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
            }
            f.dw(currentTimeMillis);
        } catch (Throwable e) {
            x.printErrStackTrace("Tinker.SubCoreHotpatch", e, "", new Object[0]);
        }
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        b.D(new String[]{"//tinker"});
        ar.getSysCmdMsgExtension().b("checktinkerupdate", this.nAG, true);
        a.xef.c(this.lzV);
        this.nAH.dead();
        a.xef.c(this.nAI);
        a.xef.c(this.nAJ);
        x.d("Tinker.SubCoreHotpatch", "onAccountRelease");
    }
}
