package com.tencent.mm.plugin.offline;

import android.os.Looper;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.p;
import java.util.HashMap;
import java.util.Map;

public class k implements ap {
    private static Map<String, String> gMU = new HashMap();
    private static HashMap<Integer, d> gwY = new HashMap();
    public static boolean oWd = false;
    public static int oWe = 10;
    private b iDo;
    private a lhZ = new 4(this);
    private af mHandler = new af(Looper.getMainLooper());
    private s oVX = null;
    private e oVY = null;
    private i oVZ = null;
    private com.tencent.mm.plugin.offline.b.a oWa = null;
    private com.tencent.mm.plugin.offline.ui.d oWb = new com.tencent.mm.plugin.offline.ui.d();
    public f oWc = new f();
    private c<sx> oWf = new c<sx>(this) {
        final /* synthetic */ k oWh;

        {
            this.oWh = r2;
            this.xen = sx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            sx sxVar = (sx) bVar;
            if (!bh.ov(sxVar.fLn.fLo)) {
                com.tencent.mm.plugin.offline.c.a.GU(sxVar.fLn.fLo);
            }
            return false;
        }
    };
    private m oWg;

    static {
        com.tencent.mm.wallet_core.a.i("OfflineBindCardRegProcess", d.class);
        com.tencent.mm.wallet_core.a.i("OfflineBindCardProcess", c.class);
        gwY.put(Integer.valueOf("OFFLINE_ORDER_STATUS".hashCode()), new d() {
            public final String[] wg() {
                return com.tencent.mm.plugin.offline.b.a.gJN;
            }
        });
    }

    public static k bgX() {
        return (k) p.s(k.class);
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        this.iDo = ((com.tencent.mm.plugin.auth.a.b) g.k(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new 3(this));
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("paymsg", this.lhZ, true);
        com.tencent.mm.sdk.b.a.xef.b(this.oWb);
        com.tencent.mm.sdk.b.a.xef.b(this.oWf);
        this.oVX = null;
        this.oVY = null;
        this.oVZ = null;
        this.oWg = new m();
    }

    public final void onAccountRelease() {
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("paymsg", this.lhZ, true);
        com.tencent.mm.sdk.b.a.xef.c(this.oWb);
        com.tencent.mm.sdk.b.a.xef.c(this.oWf);
        if (this.oWg != null) {
            Object obj = this.oWg;
            bgX();
            bgY().b(obj);
            com.tencent.mm.sdk.b.a.xef.c(obj.odL);
        }
        this.oWg = null;
        this.iDo.dead();
    }

    public static s bgY() {
        g.Dh().Ct();
        if (bgX().oVX == null) {
            bgX().oVX = new s();
        }
        return bgX().oVX;
    }

    public static e bgZ() {
        g.Dh().Ct();
        if (bgX().oVY == null) {
            bgX().oVY = new e();
        }
        return bgX().oVY;
    }

    public static i bha() {
        g.Dh().Ct();
        if (bgX().oVZ == null) {
            bgX().oVZ = new i();
        }
        return bgX().oVZ;
    }

    public static void au(int i, String str) {
        if (str != null) {
            g.Dk();
            g.Dj().CU().set(i, str);
            g.Dk();
            g.Dj().CU().lH(true);
        }
    }

    public static String un(int i) {
        g.Dk();
        return (String) g.Dj().CU().get(i, null);
    }

    public static com.tencent.mm.plugin.offline.b.a bhb() {
        if (g.Dh().Cy()) {
            if (bgX().oWa == null) {
                k bgX = bgX();
                g.Dk();
                bgX.oWa = new com.tencent.mm.plugin.offline.b.a(g.Dj().gQj);
            }
            return bgX().oWa;
        }
        throw new com.tencent.mm.z.b();
    }
}
