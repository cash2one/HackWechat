package com.tencent.mm.plugin.appbrand.report.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.a.n.2;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ a jHu;
    final /* synthetic */ p jdJ;

    a$2(a aVar, p pVar) {
        this.jHu = aVar;
        this.jdJ = pVar;
    }

    public final void run() {
        g gVar = this.jHu.jHo;
        p pVar = this.jdJ;
        Activity cg = j.cg(pVar.mContext);
        if (cg != null && cg.isFinishing()) {
            gVar.jHZ = true;
        }
        gVar.i(pVar);
        gVar.wW();
        n nVar = this.jHu.jHq;
        p pVar2 = this.jdJ;
        nVar.jIc = (String) nVar.jIV.peekFirst();
        nVar.jIe = null;
        switch (2.iHw[c.pe(nVar.appId).ordinal()]) {
            case 1:
                nVar.jId = 3;
                break;
            case 2:
                nVar.jId = 6;
                break;
            case 3:
                break;
            default:
                Intent intent = nVar.irP.iqC.jDm.jHm;
                if (intent == null) {
                    nVar.jId = 7;
                    break;
                }
                String str;
                if (intent.getComponent() == null) {
                    str = "";
                    x.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", intent);
                } else {
                    str = intent.getComponent().getClassName();
                }
                nVar.jId = 8;
                nVar.jIe = bh.az(intent.getStringExtra("appbrand_report_key_target_activity"), str);
                str = nVar.jIe;
                nVar.jIV.pollFirst();
                nVar.jIV.push(bh.ou(str));
                break;
        }
        Activity cg2 = j.cg(pVar2.mContext);
        if (cg2 != null && cg2.isFinishing()) {
            nVar.jHZ = true;
        }
        nVar.k(pVar2);
    }
}
