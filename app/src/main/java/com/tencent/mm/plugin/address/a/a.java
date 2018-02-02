package com.tencent.mm.plugin.address.a;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.c;
import java.util.HashMap;

public final class a implements ap {
    private l ilL = null;
    private com.tencent.mm.plugin.address.b.a.a ilM = null;
    private j ilN = new j();
    private k ilO = new k();

    public static a XE() {
        ar.Ha();
        a aVar = (a) bp.hY("plugin.address");
        if (aVar != null) {
            return aVar;
        }
        x.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
        Object aVar2 = new a();
        ar.Ha().a("plugin.address", aVar2);
        return aVar2;
    }

    public static com.tencent.mm.plugin.address.b.a.a XF() {
        g.Dh().Ct();
        if (XE().ilM == null) {
            XE().ilM = new com.tencent.mm.plugin.address.b.a.a();
        }
        return XE().ilM;
    }

    public static l XG() {
        g.Dh().Ct();
        if (XE().ilL == null) {
            XE().ilL = new l();
        }
        return XE().ilL;
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        com.tencent.mm.sdk.b.a.xef.b(this.ilN);
        com.tencent.mm.sdk.b.a.xef.b(this.ilO);
        l XG = XG();
        ar.Hg();
        XG.path = c.FC() + "addrmgr";
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xef.c(this.ilN);
        com.tencent.mm.sdk.b.a.xef.c(this.ilO);
    }
}
