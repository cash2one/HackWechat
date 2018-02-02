package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.10;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.wallet_core.ui.e;

class CollectMainUI$10$2 implements p$d {
    final /* synthetic */ 10 lnm;

    CollectMainUI$10$2(10 10) {
        this.lnm = 10;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                a.ayE();
                if (a.ayG()) {
                    CollectMainUI.u(this.lnm.lnh);
                    Toast.makeText(this.lnm.lnh.mController.xIM, a$i.uIB, 1).show();
                    g.pQN.h(13944, new Object[]{Integer.valueOf(8)});
                    return;
                }
                CollectMainUI.v(this.lnm.lnh);
                Toast.makeText(this.lnm.lnh.mController.xIM, a$i.uII, 1).show();
                g.pQN.h(13944, new Object[]{Integer.valueOf(7)});
                return;
            default:
                int itemId = (menuItem.getItemId() - 1) - 1;
                if (itemId < 0) {
                    x.w("MicroMsg.CollectMainUI", "illegal pos: %s", new Object[]{Integer.valueOf(itemId)});
                    return;
                }
                aqz com_tencent_mm_protocal_c_aqz = (aqz) this.lnm.lnl.get(itemId);
                if (com_tencent_mm_protocal_c_aqz.type == 1) {
                    x.w("MicroMsg.CollectMainUI", "wrong native type: %s", new Object[]{com_tencent_mm_protocal_c_aqz.url});
                    g.pQN.h(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(1), com_tencent_mm_protocal_c_aqz.fyY, "", "", "", Integer.valueOf(2)});
                    return;
                } else if (com_tencent_mm_protocal_c_aqz.type == 2) {
                    if (!bh.ov(com_tencent_mm_protocal_c_aqz.url)) {
                        e.l(this.lnm.lnh.mController.xIM, com_tencent_mm_protocal_c_aqz.url, false);
                        g.pQN.h(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(2), com_tencent_mm_protocal_c_aqz.fyY, "", "", com_tencent_mm_protocal_c_aqz.url, Integer.valueOf(2)});
                        return;
                    }
                    return;
                } else if (com_tencent_mm_protocal_c_aqz.type == 3) {
                    b qpVar = new qp();
                    qpVar.fIi.userName = com_tencent_mm_protocal_c_aqz.wyQ;
                    qpVar.fIi.fIk = bh.az(com_tencent_mm_protocal_c_aqz.wyR, "");
                    qpVar.fIi.scene = 1072;
                    qpVar.fIi.fIl = 0;
                    com.tencent.mm.sdk.b.a.xef.m(qpVar);
                    g.pQN.h(14526, new Object[]{Integer.valueOf(2), Integer.valueOf(3), com_tencent_mm_protocal_c_aqz.fyY, com_tencent_mm_protocal_c_aqz.wyQ, com_tencent_mm_protocal_c_aqz.wyR, "", Integer.valueOf(2)});
                    return;
                } else {
                    return;
                }
        }
    }
}
