package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import com.tencent.mm.ae.d;
import com.tencent.mm.by.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public final class b implements ap {
    private com.tencent.mm.sdk.e.m.b qfS = new 1(this);
    private a qfT = new 2(this);
    private m qfU = new 3(this);
    private a qfV = new a(this) {
        final /* synthetic */ b qfX;

        {
            this.qfX = r1;
        }

        public final void a(d.a aVar) {
            String a = n.a(aVar.hmq.vGZ);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
                return;
            }
            Map y = bi.y(a, "sysmsg");
            if (y != null) {
                int i = bh.getInt((String) y.get(".sysmsg.crowdtest.$clientversion"), 0);
                if (i > com.tencent.mm.protocal.d.vAz) {
                    long j = 0;
                    try {
                        j = new SimpleDateFormat("yyyy-MM-dd").parse((String) y.get(".sysmsg.crowdtest.apply.$expire")).getTime();
                    } catch (Exception e) {
                    }
                    if (j < System.currentTimeMillis()) {
                        b.bqq();
                        return;
                    }
                    a = (String) y.get(".sysmsg.crowdtest.apply.link");
                    String str = (String) y.get(".sysmsg.crowdtest.feedback.link");
                    ar.Hg();
                    c.CU().a(w.a.xvd, Integer.valueOf(i));
                    ar.Hg();
                    c.CU().a(w.a.xve, Long.valueOf(j));
                    ar.Hg();
                    c.CU().a(w.a.xvf, a);
                    ar.Hg();
                    c.CU().a(w.a.xvg, str);
                    int i2 = bh.getInt((String) y.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
                    com.tencent.mm.s.c.Bq().p(262157, i2 > 0);
                    if (i2 < 3) {
                        com.tencent.mm.s.c.Bq().aS(262157, 266261);
                    }
                    if (i2 < 2) {
                        com.tencent.mm.s.c.Bq().aS(262157, 266262);
                    }
                }
            }
        }
    };
    private m qfW = new 5(this);

    public b() {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
    }

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
        ar.getSysCmdMsgExtension().a("redpointinfo", this.qfT, true);
        ar.getSysCmdMsgExtension().a("crowdtest", this.qfV, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.qfU);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.qfW);
        ar.Hg();
        int intValue = ((Integer) c.CU().get(w.a.xvd, Integer.valueOf(com.tencent.mm.protocal.d.vAz))).intValue();
        ar.Hg();
        long longValue = ((Long) c.CU().get(w.a.xve, Long.valueOf(0))).longValue();
        if (intValue <= com.tencent.mm.protocal.d.vAz || longValue < System.currentTimeMillis()) {
            bqq();
        }
        if (z) {
            int Gd = (q.Gd() & -1048577) & -4194305;
            ar.Hg();
            c.CU().set(34, Integer.valueOf(Gd));
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_axg = new axg();
            com_tencent_mm_protocal_c_axg.vFu = 1048576;
            com_tencent_mm_protocal_c_axg.wEy = 0;
            ar.Hg();
            c.EX().b(new e.a(39, com_tencent_mm_protocal_c_axg));
            com_tencent_mm_protocal_c_axg = new axg();
            com_tencent_mm_protocal_c_axg.vFu = 4194304;
            com_tencent_mm_protocal_c_axg.wEy = 0;
            ar.Hg();
            c.EX().b(new e.a(39, com_tencent_mm_protocal_c_axg));
            x.i("MicroMsg.SubCoreSetting", "set void default open");
        }
        if (com.tencent.mm.k.g.zY().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1 && (q.FW() & 32) == 0) {
            ar.Hg();
            c.EY().a(this.qfS);
        }
    }

    public final void br(boolean z) {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
        ar.getSysCmdMsgExtension().b("redpointinfo", this.qfT, true);
        ar.getSysCmdMsgExtension().b("crowdtest", this.qfV, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.qfU);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.qfW);
        ar.Hg();
        c.EY().b(this.qfS);
    }

    static void bqq() {
        ar.Hg();
        c.CU().a(w.a.xve, Long.valueOf(0));
        ar.Hg();
        c.CU().a(w.a.xvf, "");
        com.tencent.mm.s.c.Bq().p(262157, false);
    }
}
