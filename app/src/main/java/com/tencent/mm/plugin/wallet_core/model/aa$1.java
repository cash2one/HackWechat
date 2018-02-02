package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;
import java.util.Map;

class aa$1 implements a {
    final /* synthetic */ aa sPC;

    aa$1(aa aaVar) {
        this.sPC = aaVar;
    }

    public final void a(d.a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        x.d("MicroMsg.WalletPushNotifyManager", "PayMsg:" + a);
        Map y = bi.y(a, "sysmsg");
        int i = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
        if (!aa.a(this.sPC, i, y)) {
            aa.e(i, y);
        }
    }
}
