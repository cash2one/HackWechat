package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.bs.a;
import java.util.Map;

public final class d implements a {
    public final void a(com.tencent.mm.ae.d.a aVar) {
        x.i("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "receivemsg NewYearSNSAmountLevelCtrl2016NotifyLsn");
        b.pY(67);
        if (aVar == null || aVar.hmq == null) {
            x.e("MicroMsg.NewYearSNSAmountLevelCtrl2016NotifyLsn", "onPreAddMessage cmdAM is null");
            return;
        }
        e eVar = new e();
        String a = n.a(aVar.hmq.vGZ);
        eVar.kmW = new StringBuffer();
        Map y = bi.y(a, "sysmsg");
        eVar.level = 0;
        if (y == null) {
            x.i("MicroMsg.NewYearSnsAmountLevel", "errr for paser %s", new Object[]{a});
            b.pY(68);
        } else {
            eVar.level = bh.VI((String) y.get(".sysmsg.NewYearSNSAmountLevelCtrl2016.Level"));
            x.i("MicroMsg.NewYearSnsAmountLevel", "get level %d", new Object[]{Integer.valueOf(eVar.level)});
            if (eVar.level == 0) {
                b.pY(69);
            } else if (eVar.level == 1) {
                b.pY(70);
            } else if (eVar.level == 2) {
                b.pY(71);
            } else if (eVar.level == 3) {
                b.pY(72);
            } else if (eVar.level == 4) {
                b.pY(73);
            }
        }
        x.i("MicroMsg.NewYearSnsAmountLevel", "dump NewYearSnsAmountLevel " + eVar.kmW.toString());
        g.Dk();
        g.Dj().CU().a(w.a.xqP, a);
        g.Dk();
        g.Dj().CU().lH(true);
    }
}
