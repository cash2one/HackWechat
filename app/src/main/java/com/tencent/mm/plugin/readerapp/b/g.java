package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.by.h.d;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.r.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bf;
import com.tencent.mm.z.bg;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.c;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.List;

public final class g implements ap {
    private static HashMap<Integer, d> gwY;
    private bg pAB;
    private c pAC = new c();
    private a pAD = new a();
    private d pAE = new d();
    private f pAF = new f();

    private static g bmo() {
        ar.Ha();
        g gVar = (g) bp.hY("plugin.readerapp");
        if (gVar != null) {
            return gVar;
        }
        Object gVar2 = new g();
        ar.Ha().a("plugin.readerapp", gVar2);
        return gVar2;
    }

    public static bg bmp() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (bmo().pAB == null) {
            g bmo = bmo();
            ar.Hg();
            bmo.pAB = new bg(c.EV());
        }
        return bmo().pAB;
    }

    public final void onAccountRelease() {
        com.tencent.mm.ae.d.c.b(Integer.valueOf(12399999), this.pAC);
        a.xef.c(this.pAD);
        a.xef.c(this.pAE);
        a.xef.c(this.pAF);
        i.a(e.pAA);
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
        if ((SQLiteGlobal.journalSizeLimit & i) != 0) {
            a(null);
        }
        if ((262144 & i) != 0) {
            b(null);
        }
    }

    public static void a(a aVar) {
        bmp().gW(20);
        ar.Hg();
        c.Fd().WX("newsapp");
        a(20, aVar);
    }

    public static void b(a aVar) {
        bmp().gW(11);
        ar.Hg();
        c.Fd().WX("blogapp");
        a(11, aVar);
    }

    public static void dZ(long j) {
        g(bmp().a(j, 20), 20);
    }

    public static void u(long j, int i) {
        g(bmp().b(j, i), i);
    }

    private static void g(List<bf> list, int i) {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 == 0) {
                    bh.deleteFile(t.v(((bf) list.get(i2)).HL(), i, "@T"));
                } else {
                    bh.deleteFile(t.v(((bf) list.get(i2)).HL(), i, "@S"));
                }
            }
        }
    }

    private static void c(final a aVar) {
        ag.y(new Runnable() {
            public final void run() {
                if (aVar != null) {
                    aVar.bmm();
                }
            }
        });
    }

    private static void a(int i, a aVar) {
        if (ar.Hj()) {
            ar.Dm().F(new 3(aVar, i));
        } else {
            c(aVar);
        }
    }

    public final void bq(boolean z) {
        com.tencent.mm.ae.d.c.a(Integer.valueOf(12399999), this.pAC);
        ar.Dm().F(new 4(this));
        a.xef.b(this.pAD);
        a.xef.b(this.pAE);
        a.xef.b(this.pAF);
        i.b(e.pAA);
    }

    public final void br(boolean z) {
    }
}
