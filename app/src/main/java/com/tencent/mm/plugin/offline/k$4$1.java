package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.k.4;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class k$4$1 implements Runnable {
    final /* synthetic */ a heQ;
    final /* synthetic */ String iGf;
    final /* synthetic */ 4 oWi;

    k$4$1(4 4, String str, a aVar) {
        this.oWi = 4;
        this.iGf = str;
        this.heQ = aVar;
    }

    public final void run() {
        s bgY = k.bgY();
        String str = this.iGf;
        long j = this.heQ.hmq.vHe;
        x.v("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :" + j);
        x.v("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :" + str);
        if (!TextUtils.isEmpty(str)) {
            if (bgY.dX(j)) {
                x.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:" + j);
                return;
            }
            String str2 = null;
            int i = -1;
            Map y = bi.y(str, "sysmsg");
            if (y != null) {
                String str3 = (String) y.get(".sysmsg.paymsg.ack_key");
                str2 = str3;
                i = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
            }
            if (com.tencent.mm.plugin.offline.c.a.bij()) {
                x.v("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", new Object[]{Integer.valueOf(i)});
                if (i == 7 || i == 10) {
                    bgY.GP(str);
                    bgY.GQ(str);
                } else if (g.dF(str2, str)) {
                    g.pQN.a(135, 70, 1, true);
                    bgY.GP(str);
                    bgY.GQ(str);
                }
            } else {
                g.dF(str2, str);
                bgY.GP(str);
                bgY.GQ(str);
            }
            if (bgY.oUk.size() > 10) {
                bgY.oUk.remove(bgY.oUk.size() - 1);
            }
            bgY.oUk.add(0, Long.valueOf(j));
        }
    }
}
