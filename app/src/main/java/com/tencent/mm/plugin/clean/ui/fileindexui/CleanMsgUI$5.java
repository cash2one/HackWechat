package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class CleanMsgUI$5 implements h {
    final /* synthetic */ CleanMsgUI lhh;

    CleanMsgUI$5(CleanMsgUI cleanMsgUI) {
        this.lhh = cleanMsgUI;
    }

    public final void cl(int i, int i2) {
        CleanMsgUI.a(this.lhh).setMessage(this.lhh.getString(R.l.dTM, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void bW(final long j) {
        x.i("MicroMsg.CleanMsgUI", "onDeleteEnd %d ", new Object[]{Long.valueOf(j)});
        ag.y(new Runnable(this) {
            final /* synthetic */ CleanMsgUI$5 lhj;

            public final void run() {
                long j = 0;
                if (CleanMsgUI.a(this.lhj.lhh) != null) {
                    CleanMsgUI.a(this.lhj.lhh).dismiss();
                }
                long j2 = j.ayv().leY;
                long j3 = j.ayv().leY - j;
                if (j3 < 0) {
                    j2 = j.ayv().leW - j2;
                } else {
                    j2 = j.ayv().leW - j;
                    j = j3;
                }
                j.ayv().leY = j;
                j.ayv().leW = j2;
                CleanMsgUI.a(this.lhj.lhh, j.ayv().leW, j.ayv().leX, j.ayv().leY);
            }
        });
        g.pQN.a(714, 13, 1, false);
    }
}
