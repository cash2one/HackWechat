package com.tencent.mm.plugin.collect.ui;

import android.widget.Toast;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.asa;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMSwitchBtn$a;

class CollectBillUI$6 implements MMSwitchBtn$a {
    final /* synthetic */ CollectBillUI llV;

    CollectBillUI$6(CollectBillUI collectBillUI) {
        this.llV = collectBillUI;
    }

    public final void cw(boolean z) {
        int i;
        x.i("MicroMsg.CollectBillUI", "update switch: %B", new Object[]{Boolean.valueOf(z)});
        CollectBillUI.j(this.llV).nB(z);
        CollectBillUI.k(this.llV).nB(z);
        if (z) {
            CollectBillUI.a(this.llV, CollectBillUI.l(this.llV) | 32768);
            CollectBillUI.m(this.llV).setImageResource(h.uGu);
            CollectBillUI.n(this.llV).setImageResource(h.uGu);
            Toast.makeText(this.llV.mController.xIM, i.uII, 1).show();
            g.pQN.h(13944, new Object[]{Integer.valueOf(11)});
            i = 1;
        } else {
            CollectBillUI.a(this.llV, CollectBillUI.l(this.llV) & -32769);
            CollectBillUI.m(this.llV).setImageResource(h.uGt);
            CollectBillUI.n(this.llV).setImageResource(h.uGt);
            Toast.makeText(this.llV.mController.xIM, i.uIB, 1).show();
            g.pQN.h(13944, new Object[]{Integer.valueOf(12)});
            i = 2;
        }
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dj().CU().set(147457, Long.valueOf(CollectBillUI.l(this.llV)));
        a com_tencent_mm_protocal_c_asa = new asa();
        com_tencent_mm_protocal_c_asa.pQk = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EX().b(new e.a(c.CTRL_INDEX, com_tencent_mm_protocal_c_asa));
        if (i == 1) {
            com.tencent.mm.plugin.collect.a.a.ayE().ayH();
        } else {
            com.tencent.mm.plugin.collect.a.a.ayE().ayI();
        }
    }
}
