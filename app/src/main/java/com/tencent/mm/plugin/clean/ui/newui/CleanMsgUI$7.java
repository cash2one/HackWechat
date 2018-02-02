package com.tencent.mm.plugin.clean.ui.newui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;

class CleanMsgUI$7 implements h {
    final /* synthetic */ CleanMsgUI lhT;

    CleanMsgUI$7(CleanMsgUI cleanMsgUI) {
        this.lhT = cleanMsgUI;
    }

    public final void cl(int i, int i2) {
        CleanMsgUI.c(this.lhT).setMessage(this.lhT.getString(R.l.dTM, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void bW(long j) {
        ag.y(new 1(this, j));
        g.pQN.a(282, 12, 1, false);
        g.pQN.a(282, 13, j / 1024, false);
    }
}
