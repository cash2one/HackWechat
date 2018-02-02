package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.gmtrace.Constants;
import com.tencent.mm.pluginsdk.model.i.a;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

class IPCallRechargeUI$1 implements a {
    final /* synthetic */ IPCallRechargeUI nLL;

    IPCallRechargeUI$1(IPCallRechargeUI iPCallRechargeUI) {
        this.nLL = iPCallRechargeUI;
    }

    public final void u(ArrayList<q> arrayList) {
        IPCallRechargeUI.a(this.nLL).nGs = System.currentTimeMillis();
        if (arrayList == null || arrayList.size() <= 0) {
            if (IPCallRechargeUI.f(this.nLL) != null && IPCallRechargeUI.f(this.nLL).isShowing()) {
                IPCallRechargeUI.f(this.nLL).dismiss();
            }
            x.i("MicroMsg.IPCallRechargeUI", "[onQueryFinish] result=null");
            IPCallRechargeUI.a(this.nLL, 10236);
            this.nLL.aUB();
            return;
        }
        IPCallRechargeUI.a(this.nLL, new String[arrayList.size()]);
        IPCallRechargeUI.b(this.nLL, new String[arrayList.size()]);
        q qVar = (q) arrayList.get(0);
        if (qVar.vdH == 10232) {
            x.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product OK size=" + arrayList.size());
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                qVar = (q) it.next();
                IPCallRechargeUI.b(this.nLL)[i] = new BigDecimal(qVar.vdG).divide(new BigDecimal(Constants.MAX_BUFFER_SIZE)).toString();
                IPCallRechargeUI.c(this.nLL)[i] = qVar.vdF;
                i++;
            }
            if (IPCallRechargeUI.d(this.nLL) > 0 && IPCallRechargeUI.c(this.nLL).length > 0) {
                String str = IPCallRechargeUI.c(this.nLL)[0];
                if (!(bh.ov(str) || str.equals(IPCallRechargeUI.e(this.nLL)))) {
                    x.i("MicroMsg.IPCallRechargeUI", "remote currency:" + IPCallRechargeUI.e(this.nLL) + ",google wallet currency:" + str);
                    IPCallRechargeUI.a(this.nLL, str);
                    return;
                }
            }
            if (IPCallRechargeUI.f(this.nLL) != null && IPCallRechargeUI.f(this.nLL).isShowing()) {
                IPCallRechargeUI.f(this.nLL).dismiss();
            }
            this.nLL.aUB();
            return;
        }
        if (IPCallRechargeUI.f(this.nLL) != null && IPCallRechargeUI.f(this.nLL).isShowing()) {
            IPCallRechargeUI.f(this.nLL).dismiss();
        }
        IPCallRechargeUI.a(this.nLL, qVar.vdH);
        x.i("MicroMsg.IPCallRechargeUI", "OnGoogleQueryFinish Product Failed Status:" + IPCallRechargeUI.g(this.nLL));
        this.nLL.aUB();
    }
}
