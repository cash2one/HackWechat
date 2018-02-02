package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.z.q;

class MallIndexBaseUI$3 implements d {
    final /* synthetic */ MallIndexBaseUI oma;

    MallIndexBaseUI$3(MallIndexBaseUI mallIndexBaseUI) {
        this.oma = mallIndexBaseUI;
    }

    public final void cn(int i, int i2) {
        switch (i2) {
            case 0:
                g.pQN.h(11458, new Object[]{Integer.valueOf(2)});
                if (q.Gf()) {
                    a.b(this.oma.mController.xIM, "PayURemittanceProcess", null);
                    return;
                } else {
                    a.b(this.oma.mController.xIM, "RemittanceProcess", null);
                    return;
                }
            case 1:
                g.pQN.h(11458, new Object[]{Integer.valueOf(3)});
                h.W(this.oma, 2);
                return;
            default:
                return;
        }
    }
}
