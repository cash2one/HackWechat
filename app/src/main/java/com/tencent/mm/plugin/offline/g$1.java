package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class g$1 implements e {
    final /* synthetic */ g oVG;

    g$1(g gVar) {
        this.oVG = gVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if ((kVar instanceof d) && i == 0 && i2 == 0) {
            d dVar = (d) kVar;
            g.access$002(dVar.oWn);
            if (g.bl() == 0) {
                g.access$002(g.JM());
            }
            x.i(g.aqF(), "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", new Object[]{dVar.oWo, dVar.oWm});
            if (bh.ov(dVar.oWm) || bh.ov(dVar.oWo)) {
                x.i(g.aqF(), "OfflineGetMsgLogic msg is null");
            } else if (g.dF(dVar.oWo, dVar.oWm)) {
                x.i(g.aqF(), "from cgi");
                if (bi.y(dVar.oWm, "sysmsg") != null) {
                    g.pQN.a(135, 71, 1, true);
                    k.bgX();
                    s bgY = k.bgY();
                    String str2 = dVar.oWm;
                    if (!TextUtils.isEmpty(str2)) {
                        String str3 = null;
                        int i3 = -1;
                        Map y = bi.y(str2, "sysmsg");
                        if (y != null) {
                            String str4 = (String) y.get(".sysmsg.paymsg.ack_key");
                            str3 = str4;
                            i3 = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                        }
                        if (!a.bij()) {
                            g.dF(str3, str2);
                            bgY.GP(str2);
                            bgY.GQ(str2);
                        } else if (!(i3 == 7 || i3 == 10 || !g.dF(str3, str2))) {
                            g.pQN.a(135, 70, 1, true);
                            bgY.GP(str2);
                            bgY.GQ(str2);
                        }
                    }
                } else {
                    return;
                }
            }
            x.i(g.aqF(), "mIntercal=" + g.bl());
            long bl = (long) g.bl();
            g.a(this.oVG).J(bl, bl);
        }
    }
}
