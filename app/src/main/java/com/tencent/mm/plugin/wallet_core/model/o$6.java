package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.q;
import java.util.Map;

class o$6 implements a {
    final /* synthetic */ o sPi;

    o$6(o oVar) {
        this.sPi = oVar;
    }

    public final void a(d.a aVar) {
        Map y = bi.y(n.a(aVar.hmq.vGZ), "sysmsg");
        if (y != null) {
            int i = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
            x.i("MicroMsg.SubCoreNfc", "got a pay msg, type = " + i);
            switch (i) {
                case 16:
                    i = bh.getInt((String) y.get(".sysmsg.paymsg.Flag"), 0);
                    x.i("MicroMsg.SubCoreNfc", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=" + i);
                    if (i == 1) {
                        x.i("MicroMsg.SubCoreNfc", "open wallet");
                        q.Gc();
                        return;
                    } else if (i == 2) {
                        x.i("MicroMsg.SubCoreNfc", "close wallet");
                        i = q.FY() & -32769;
                        g.Dk();
                        g.Dj().CU().set(40, Integer.valueOf(i));
                        return;
                    } else {
                        return;
                    }
                case 17:
                    i = bh.getInt((String) y.get(".sysmsg.paymsg.WalletType"), -1);
                    x.i("MicroMsg.SubCoreNfc", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=" + i);
                    if (i >= 0) {
                        g.Dk();
                        g.Dj().CU().set(339975, Integer.valueOf(i));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
