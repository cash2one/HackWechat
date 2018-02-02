package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o.a;

class SnsMsgUI$13 implements a {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$13(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final void Xw() {
    }

    public final void Xv() {
        x.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.d(this.rDE).hKb + " unread:" + ae.bvA().Tq() + "  showcount:" + SnsMsgUI.d(this.rDE).kUH);
        if (SnsMsgUI.d(this.rDE).getCount() == 0) {
            SnsMsgUI.b(this.rDE).setVisibility(8);
            SnsMsgUI.c(this.rDE).setVisibility(0);
            this.rDE.enableOptionMenu(false);
        } else {
            SnsMsgUI.b(this.rDE).setVisibility(0);
            SnsMsgUI.c(this.rDE).setVisibility(8);
            this.rDE.enableOptionMenu(true);
        }
        if ((SnsMsgUI.d(this.rDE).awe() && ae.bvA().Tq() == 0) || ae.bvA().Tq() == ae.bvA().byc()) {
            SnsMsgUI.e(this.rDE).setVisibility(8);
        }
    }
}
