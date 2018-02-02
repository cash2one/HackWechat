package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.vending.c.a;

class PaylistAAUI$2 implements a<Void, o> {
    final /* synthetic */ PaylistAAUI ikp;

    PaylistAAUI$2(PaylistAAUI paylistAAUI) {
        this.ikp = paylistAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        o oVar = (o) obj;
        if (PaylistAAUI.d(this.ikp) != null) {
            PaylistAAUI.d(this.ikp).dismiss();
        }
        String str = "MicroMsg.PaylistAAUI";
        String str2 = "aapay return, alertItem: %s, alertItem.flag: %s";
        Object[] objArr = new Object[2];
        objArr[0] = oVar.vDq;
        objArr[1] = Integer.valueOf(oVar.vDq != null ? oVar.vDq.fDt : 0);
        x.i(str, str2, objArr);
        if (oVar.vDq == null || oVar.vDq.fDt != 1) {
            x.d("MicroMsg.PaylistAAUI", "aapay return, reqKey: %s", new Object[]{oVar.ods});
            PaylistAAUI.a(this.ikp, oVar);
        } else {
            String str3 = oVar.vDq.fyY;
            String str4 = oVar.vDq.odw;
            str = oVar.vDq.odx;
            i.a aVar = new i.a(this.ikp);
            aVar.YG(str3);
            aVar.YI(str).a(new 1(this, oVar));
            aVar.YJ(str4);
            aVar.akx().show();
        }
        return zBS;
    }
}
