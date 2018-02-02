package com.tencent.mm.aq;

import android.os.Looper;
import com.tencent.mm.ae.e;
import com.tencent.mm.aq.a.a;
import com.tencent.mm.aq.d.b;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import java.util.HashMap;

public class o implements ap {
    private static HashMap<Integer, d> gwY;
    private j hCA = new j();
    private d hCB = null;
    private h hCC = new h();
    private b hCD = null;
    private p hCE = null;
    private c hCF = new 1(this);
    private a hCG = null;
    private SFSContext hCH = null;
    private SFSContext hCI = null;
    private g hCx;
    private i hCy;
    private c hCz;

    private static synchronized o Pt() {
        o oVar;
        synchronized (o.class) {
            oVar = (o) p.s(o.class);
        }
        return oVar;
    }

    public static i Pu() {
        if (Pt().hCy == null) {
            Pt().hCy = new i();
        }
        return Pt().hCy;
    }

    public static c Pv() {
        g.Dh().Ct();
        if (Pt().hCz == null) {
            Pt().hCz = new c();
        }
        return Pt().hCz;
    }

    public static g Pw() {
        g.Dh().Ct();
        if (Pt().hCx == null) {
            Pt().hCx = new g(g.Dj().gQj);
        }
        return Pt().hCx;
    }

    public static d Px() {
        g.Dh().Ct();
        if (Pt().hCB == null) {
            Pt().hCB = new d();
        }
        return Pt().hCB;
    }

    public static b Py() {
        g.Dh().Ct();
        if (Pt().hCD == null) {
            Pt().hCD = new b(Looper.getMainLooper());
        }
        return Pt().hCD;
    }

    public static p Pz() {
        g.Dh().Ct();
        if (Pt().hCE == null) {
            Pt().hCE = new p();
        }
        return Pt().hCE;
    }

    public static a PA() {
        g.Dh().Ct();
        if (Pt().hCG == null) {
            Pt().hCG = a.PH();
        }
        return Pt().hCG;
    }

    public static SFSContext PB() {
        return null;
    }

    public final void onAccountRelease() {
        o Pt = Pt();
        if (Pt.hCy != null) {
            e eVar = Pt.hCy;
            eVar.flT = 0;
            g.Di().gPJ.b(110, eVar);
        }
        if (Pt.hCD != null) {
            b bVar = Pt.hCD;
            synchronized (bVar.hzl) {
                bVar.hzl.clear();
                bVar.hzm = 0;
                Px().a(bVar);
            }
            com.tencent.mm.sdk.b.a.xef.c(bVar.hzx);
            com.tencent.mm.sdk.b.a.xef.c(bVar.hzy);
        }
        if (Pt.hCB != null) {
            e eVar2 = Pt.hCB;
            x.i("ModelImage.DownloadImgService", "on detach");
            x.i("ModelImage.DownloadImgService", "cancel all net scene");
            eVar2.hzH = true;
            eVar2.b(eVar2.hzF);
            while (eVar2.hzD.size() > 0) {
                eVar2.b((b) eVar2.hzD.get(0));
            }
            eVar2.Pc();
            g.Di().gPJ.b(109, eVar2);
        }
        if (Pt.hCE != null) {
            p pVar = Pt.hCE;
            x.i("MicroMsg.UrlImageCacheService", "detach");
            pVar.hCK.clear();
            pVar.hCM = true;
        }
        PC();
        com.tencent.mm.ae.d.c.b(Integer.valueOf(3), this.hCC);
        com.tencent.mm.ae.d.c.b(Integer.valueOf(23), this.hCC);
        com.tencent.mm.cache.e.a.a("local_cdn_img_cache", null);
        com.tencent.mm.sdk.b.a.xef.c(this.hCF);
        if (Pt.hCG != null) {
            Pt.hCG.detach();
            Pt.hCG = null;
        }
        if (Pt.hCH != null) {
            Pt.hCH.release();
            Pt.hCH = null;
        }
        if (Pt.hCI != null) {
            Pt.hCI.release();
            Pt.hCI = null;
        }
    }

    public static void PC() {
        g gVar = Pt().hCx;
        if (gVar != null) {
            x.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", new Object[]{bh.cgy()});
            gVar.hAw.a(new g$3(gVar));
        }
        a aVar = Pt().hCG;
        if (aVar != null) {
            aVar.detach();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("IMGINFO_TABLE".hashCode()), new 2());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        com.tencent.mm.ae.d.c.a(Integer.valueOf(3), this.hCC);
        com.tencent.mm.ae.d.c.a(Integer.valueOf(23), this.hCC);
        com.tencent.mm.cache.e.a.a("local_cdn_img_cache", this.hCA);
        com.tencent.mm.sdk.b.a.xef.b(this.hCF);
    }

    public final void br(boolean z) {
    }
}
