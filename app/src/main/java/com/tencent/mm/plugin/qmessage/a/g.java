package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.by.h.d;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.c;
import java.util.HashMap;

public final class g implements ap {
    private static HashMap<Integer, d> gwY;
    private e pnA;
    private f pnB = new f();
    private a pnC = new a();
    private b pnD = new b();

    private static g bjX() {
        ar.Ha();
        g gVar = (g) bp.hY("plugin.qmessage");
        if (gVar != null) {
            return gVar;
        }
        Object gVar2 = new g();
        ar.Ha().a("plugin.qmessage", gVar2);
        return gVar2;
    }

    public static e bjY() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bjX().pnA == null) {
            g bjX = bjX();
            ar.Hg();
            bjX.pnA = new e(c.EV());
        }
        return bjX().pnA;
    }

    public final void onAccountRelease() {
        com.tencent.mm.ae.d.c.b(Integer.valueOf(36), this.pnB);
        com.tencent.mm.ae.d.c.b(Integer.valueOf(39), this.pnB);
        a.xef.c(this.pnC);
        a.xef.c(this.pnD);
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("QCONTACT_TABLE".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
        x.d("MicroMsg.SubCoreQMsg", "clear plugin");
        if ((i & 32) != 0) {
            bka();
        }
    }

    public static void bjZ() {
        ar.Hg();
        if (c.Fd().WY("qmessage") == null) {
            ae aeVar = new ae();
            aeVar.setUsername("qmessage");
            aeVar.setContent("");
            aeVar.aj(bh.Wp());
            aeVar.eR(0);
            aeVar.eO(0);
            ar.Hg();
            c.Fd().d(aeVar);
            return;
        }
        ar.Hg();
        cf Ex = c.Fa().Ex("qmessage");
        ae aeVar2 = new ae();
        aeVar2.setUsername("qmessage");
        aeVar2.setContent(Ex == null ? "" : Ex.field_content);
        aeVar2.aj(bh.Wp());
        aeVar2.eR(0);
        aeVar2.eO(0);
        ar.Hg();
        c.Fd().a(aeVar2, "qmessage");
    }

    public static void bka() {
        ba.Hy();
        ar.Hg();
        c.Fd().EE("@qqim");
        ar.Hg();
        c.Fd().WX("qmessage");
    }

    public final void bq(boolean z) {
        com.tencent.mm.ae.d.c.a(Integer.valueOf(36), this.pnB);
        com.tencent.mm.ae.d.c.a(Integer.valueOf(39), this.pnB);
        a.xef.b(this.pnC);
        a.xef.b(this.pnD);
    }

    public final void br(boolean z) {
    }
}
