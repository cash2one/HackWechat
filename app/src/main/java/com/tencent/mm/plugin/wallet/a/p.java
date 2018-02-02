package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.q;
import java.io.File;
import java.util.HashMap;

public class p implements ap {
    private int fKy = 0;
    private int sDR = 0;
    private o sDS = new o();
    private v sDT = new v();
    private i sDU = new i();
    private b sDV = new b(this) {
        final /* synthetic */ p sDY;

        {
            this.sDY = r1;
        }

        public final void a(int i, m mVar, Object obj) {
            int intValue;
            if (bh.o(obj, 0) == 339975) {
                g.Dk();
                intValue = ((Integer) g.Dj().CU().get(339975, Integer.valueOf(0))).intValue();
                if (intValue != this.sDY.sDR) {
                    ao.bYV().reset();
                    this.sDY.sDR = intValue;
                }
            } else if (a.xrD.equals(obj)) {
                g.Dk();
                intValue = ((Integer) g.Dj().CU().get(a.xrD, Integer.valueOf(0))).intValue();
                if (intValue != this.sDY.fKy) {
                    ao.bYV().reset();
                    this.sDY.fKy = intValue;
                }
            }
        }
    };
    private com.tencent.mm.plugin.messenger.foundation.a.m sDW = new 2(this);
    private j sDX = new j();

    static {
        com.tencent.mm.wallet_core.a.i("ForgotPwdProcess", com.tencent.mm.plugin.wallet.pwd.a.class);
        com.tencent.mm.wallet_core.a.i("BindCardProcess", com.tencent.mm.plugin.wallet_core.b.b.class);
    }

    public p() {
        File file = new File(com.tencent.mm.plugin.wallet_core.d.b.bMk());
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static p bJN() {
        return (p) com.tencent.mm.z.p.s(p.class);
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        g.Dk();
        this.sDR = ((Integer) g.Dj().CU().get(339975, Integer.valueOf(0))).intValue();
        g.Dk();
        this.fKy = ((Integer) g.Dj().CU().get(a.xrD, Integer.valueOf(0))).intValue();
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("paymsg", this.sDW);
        com.tencent.mm.sdk.b.a.xef.b(this.sDS);
        com.tencent.mm.sdk.b.a.xef.b(this.sDT);
        com.tencent.mm.sdk.b.a.xef.b(this.sDU);
        this.sDX.ceO();
        g.Dk();
        g.Dj().CU().a(this.sDV);
        g.Dk();
        g.Dj().CU().a(a.xxG, Boolean.valueOf(false));
    }

    public final void onAccountRelease() {
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("paymsg", this.sDW);
        com.tencent.mm.sdk.b.a.xef.c(this.sDS);
        com.tencent.mm.sdk.b.a.xef.c(this.sDT);
        com.tencent.mm.sdk.b.a.xef.c(this.sDU);
        this.sDX.dead();
        g.Dk();
        g.Dj().CU().b(this.sDV);
    }

    public static ag bJO() {
        return o.bLq();
    }

    public static String NY() {
        g.Dk();
        String str = (String) g.Dj().CU().get(6, null);
        String De = com.tencent.mm.sdk.platformtools.ao.De(str);
        if (bh.ov(str)) {
            return "";
        }
        return str.substring(De.length() + 1);
    }

    public static String bJP() {
        g.Dk();
        String str = (String) g.Dj().CU().get(6, null);
        if (bh.ov(str)) {
            str = "";
        } else {
            str = com.tencent.mm.sdk.platformtools.ao.De(str.replace("+", ""));
        }
        if (!bh.ov(str)) {
            return str;
        }
        if (q.Gf()) {
            return "27";
        }
        return "86";
    }
}
