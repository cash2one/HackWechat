package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.ui.SelectDateUI.1;

class SelectDateUI$1$1 implements Runnable {
    final /* synthetic */ 1 ldp;

    SelectDateUI$1$1(1 1) {
        this.ldp = 1;
    }

    public final void run() {
        SelectDateUI.c(this.ldp.ldo).laL = SelectDateUI.b(this.ldp.ldo) == -1 ? System.currentTimeMillis() * 1000 : SelectDateUI.b(this.ldp.ldo);
        SelectDateUI.c(this.ldp.ldo).a(this.ldp.ldo, SelectDateUI.d(this.ldp.ldo).values());
        if (SelectDateUI.d(this.ldp.ldo).size() == 0) {
            SelectDateUI.e(this.ldp.ldo).setVisibility(0);
            SelectDateUI.c(this.ldp.ldo).setVisibility(8);
            SelectDateUI.e(this.ldp.ldo).setText(this.ldp.ldo.getString(R.l.dSE));
            return;
        }
        SelectDateUI.e(this.ldp.ldo).setVisibility(8);
        SelectDateUI.c(this.ldp.ldo).setVisibility(0);
    }
}
