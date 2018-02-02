package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;

class RemittanceBusiUI$21 implements Runnable {
    final /* synthetic */ RemittanceBusiUI pOd;

    RemittanceBusiUI$21(RemittanceBusiUI remittanceBusiUI) {
        this.pOd = remittanceBusiUI;
    }

    public final void run() {
        RemittanceBusiUI.v(this.pOd).setText(RemittanceBusiUI.u(this.pOd));
        CharSequence dC = e.dC(e.gu(RemittanceBusiUI.w(this.pOd)), 10);
        if (!bh.ov(RemittanceBusiUI.x(this.pOd))) {
            dC = this.pOd.getString(a$i.uMZ, new Object[]{dC, RemittanceBusiUI.x(this.pOd)});
        }
        RemittanceBusiUI.y(this.pOd).setText(i.b(this.pOd, dC, RemittanceBusiUI.y(this.pOd).getTextSize()));
        if (RemittanceBusiUI.h(this.pOd) != null) {
            if (RemittanceBusiUI.h(this.pOd).pKa != 1) {
                RemittanceBusiUI.z(this.pOd).setVisibility(8);
                return;
            } else if (!bh.ov(RemittanceBusiUI.h(this.pOd).pKb)) {
                if (RemittanceBusiUI.h(this.pOd).pKj == 1) {
                    RemittanceBusiUI.z(this.pOd).vnf = true;
                } else {
                    RemittanceBusiUI.z(this.pOd).vnf = false;
                }
                int b = b.b(this.pOd, 36.0f);
                RemittanceBusiUI.z(this.pOd).i(RemittanceBusiUI.h(this.pOd).pKb, b, b, -1);
                return;
            } else if (!bh.ov(RemittanceBusiUI.w(this.pOd))) {
                if (RemittanceBusiUI.h(this.pOd).pKj == 1) {
                    a.b.o(RemittanceBusiUI.z(this.pOd), RemittanceBusiUI.w(this.pOd));
                    return;
                } else {
                    a.b.a(RemittanceBusiUI.z(this.pOd), RemittanceBusiUI.w(this.pOd));
                    return;
                }
            }
        }
        RemittanceBusiUI.z(this.pOd).setVisibility(8);
    }
}
