package com.tencent.mm.ad;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import com.tencent.mm.z.q;
import java.util.HashMap;

public class n implements ap {
    private static HashMap<Integer, d> gwY;
    private i hlP;
    private d hlQ;
    private c hlR;
    private g hlS;
    private String hlT;
    private ak hlU = new ak(g.Dm().oAt.getLooper(), new a(this) {
        final /* synthetic */ n hlV;

        {
            this.hlV = r1;
        }

        public final boolean uF() {
            if (!g.Dh().Cy() || n.Jz() == null) {
                x.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", Boolean.valueOf(g.Dh().Cy()), n.Jz());
            } else {
                if (((Boolean) g.Dj().CU().get(90113, Boolean.valueOf(false))).booleanValue()) {
                    n.JU();
                    n.JT();
                }
                g.Dj().CU().set(90113, Boolean.valueOf(false));
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|upAssetsHandler";
        }
    }, false);

    static /* synthetic */ void JU() {
        try {
            Context context = ac.getContext();
            for (String str : d.hkY.keySet()) {
                int intValue = d.hkY.containsKey(str) ? ((Integer) d.hkY.get(str)).intValue() : 0;
                if (intValue != 0) {
                    x.d("MicroMsg.SubCoreAvatar", "updateAssetsAvatar user:%s ", str);
                    Jz().e(str, com.tencent.mm.compatible.f.a.decodeResource(context.getResources(), intValue));
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.SubCoreAvatar", "exception:%s", bh.i(e));
        }
    }

    public static n JP() {
        return (n) p.s(n.class);
    }

    public static i JQ() {
        g.Dh().Ct();
        if (JP().hlP == null) {
            JP().hlP = new i(g.Dj().gQj);
        }
        return JP().hlP;
    }

    public static d Jz() {
        g.Dh().Ct();
        if (JP().hlQ == null) {
            JP().hlQ = new d();
        }
        return JP().hlQ;
    }

    public static g JR() {
        g.Dh().Ct();
        if (JP().hlS == null) {
            JP().hlS = new g(g.Dj().gQj);
        }
        return JP().hlS;
    }

    public static c JS() {
        g.Dh().Ct();
        if (JP().hlR == null) {
            JP().hlR = new c();
        }
        return JP().hlR;
    }

    public final void onAccountRelease() {
        this.hlU.TG();
        if (JP().hlQ != null) {
            d.reset();
        }
        e eVar = JP().hlR;
        if (eVar != null) {
            g.CG().b(123, eVar);
        }
        i iVar = JP().hlP;
        if (iVar != null) {
            iVar.hlB.clear();
        }
        if (this.hlT != null) {
            FileOp.lY(this.hlT);
            this.hlT = null;
        }
    }

    public final void gd(int i) {
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return i.gJN;
            }
        });
        gwY.put(Integer.valueOf("HDHEADIMGINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return g.gJN;
            }
        });
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void bq(boolean z) {
        FileOp.mh(g.Dj().gQi + "sfs");
        this.hlT = com.tencent.mm.plugin.f.a.aoe();
        FileOp.a(this.hlT, null, new Builder().setDBDirectory(g.Dj().cachePath + "sfs").setStoragePath(c.Fy()).setName("avatar"));
        if (z) {
            x.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
            g.Dj().CU().set(90113, Boolean.valueOf(true));
            try {
                String FS = q.FS();
                d Jz = Jz();
                d.y(FS, false);
                d.y(FS, true);
                Jz.d(FS, null);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SubCoreAvatar", e, "Failed to refresh avatar.", new Object[0]);
            }
        }
        this.hlU.J(10000, 10000);
    }

    static Context getContext() {
        return ac.getContext();
    }

    public final void br(boolean z) {
        if (this.hlT != null) {
            FileOp.lY(this.hlT);
            this.hlT = com.tencent.mm.plugin.f.a.aoe();
            FileOp.a(this.hlT, null, new Builder().setDBDirectory(g.Dj().cachePath + "sfs").setStoragePath(c.Fy()).setName("avatar"));
        }
    }

    public static boolean JT() {
        if (bh.a((Boolean) g.Dj().CU().get(59, null), false)) {
            return true;
        }
        boolean z;
        Jz();
        String x = d.x(q.FS(), false);
        if (FileOp.bO(x) || FileOp.bO(x + ".bm")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        x = q.FS();
        if (bh.ov(x)) {
            return false;
        }
        Bitmap jj = b.jj(c.Fi() + "user_" + com.tencent.mm.a.g.s(x.getBytes()) + ".png");
        if (jj == null || jj.isRecycled()) {
            return false;
        }
        return Jz().e(x, jj);
    }
}
