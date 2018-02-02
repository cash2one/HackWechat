package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a.h;
import com.tencent.mm.protocal.c.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.vending.g.b;

public final class d implements e {
    private static int igl = 20;
    private static int igm = 20;
    private static int ign = 20;
    private static long igo = 4000000;
    private static long igp = 200000;
    b igh;
    public String igq = "";
    public String igr = "";

    private d(String str, String str2) {
        this.igq = str;
        this.igr = str2;
    }

    public static int WE() {
        g.Dk();
        return ((Integer) g.Dj().CU().get(a.USERINFO_AA_MAX_PAYER_NUM_INT, Integer.valueOf(igl))).intValue();
    }

    public static int WF() {
        g.Dk();
        return ((Integer) g.Dj().CU().get(a.USERINFO_AA_MAX_TOTAL_USER_NUM_INT, Integer.valueOf(ign))).intValue();
    }

    public static long WG() {
        g.Dk();
        return ((Long) g.Dj().CU().get(a.USERINFO_AA_MAX_PER_AMOUNT_LONG, Long.valueOf(igp))).longValue();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            m mVar = ((h) kVar).igZ;
            x.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", Integer.valueOf(mVar.liH), mVar.liI, Integer.valueOf(mVar.vDk), Integer.valueOf(mVar.vDl), Integer.valueOf(mVar.vDm), Long.valueOf(mVar.vDn), Long.valueOf(mVar.vDo), mVar.liT, mVar.liU);
            if (mVar.liH == 0) {
                g.Dk();
                g.Dj().CU().a(a.USERINFO_AA_MAX_PAYER_NUM_INT, Integer.valueOf(mVar.vDk));
                g.Dk();
                g.Dj().CU().a(a.USERINFO_AA_MAX_RECEIVER_NUM_INT, Integer.valueOf(mVar.vDl));
                g.Dk();
                g.Dj().CU().a(a.USERINFO_AA_MAX_TOTAL_USER_NUM_INT, Integer.valueOf(mVar.vDm));
                g.Dk();
                g.Dj().CU().a(a.USERINFO_AA_MAX_TOTAL_AMOUNT_LONG, Long.valueOf(mVar.vDn));
                g.Dk();
                g.Dj().CU().a(a.USERINFO_AA_MAX_PER_AMOUNT_LONG, Long.valueOf(mVar.vDo));
                com.tencent.mm.plugin.report.service.g.pQN.a(407, 33, 1, false);
                com.tencent.mm.vending.g.g.a(this.igh, new d(mVar.liU, mVar.liT));
                return;
            }
            com.tencent.mm.vending.g.g.czQ().cl(Boolean.valueOf(false));
            com.tencent.mm.plugin.report.service.g.pQN.a(407, 35, 1, false);
            return;
        }
        com.tencent.mm.vending.g.g.czQ().cl(Boolean.valueOf(false));
        com.tencent.mm.plugin.report.service.g.pQN.a(407, 34, 1, false);
    }
}
