package com.tencent.mm.plugin.offline;

import com.tencent.mm.g.a.tj;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s$f;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;

public final class m implements a {
    c odL = new 1(this);

    public m() {
        com.tencent.mm.sdk.b.a.xef.b(this.odL);
        k.bgX();
        k.bgY().a(this);
    }

    private static void av(int i, String str) {
        b tjVar = new tj();
        tjVar.fLO.fLQ = i;
        tjVar.fLO.action = 4;
        tjVar.fLO.content = str;
        com.tencent.mm.sdk.b.a.xef.m(tjVar);
    }

    public final boolean a(s.c cVar) {
        if (cVar.oXj == 6) {
            s$f com_tencent_mm_plugin_offline_a_s_f = (s$f) cVar;
            if (com_tencent_mm_plugin_offline_a_s_f.oXr.sNW == null || com_tencent_mm_plugin_offline_a_s_f.oXr.sNW.size() <= 0) {
                av(9, ac.getContext().getString(i.uXq));
            } else {
                Commodity commodity = (Commodity) com_tencent_mm_plugin_offline_a_s_f.oXr.sNW.get(0);
                av(0, ac.getContext().getString(i.uXs, new Object[]{e.d(commodity.ljg, commodity.paz)}));
            }
        } else if (cVar.oXj == 8) {
            av(6, ac.getContext().getString(i.uXq));
        } else if (cVar.oXj == 5) {
            av(7, bh.az(((s.e) cVar).oXn, ""));
        } else if (cVar.oXj == 4) {
            av(8, ac.getContext().getString(i.uXr));
        }
        return false;
    }
}
