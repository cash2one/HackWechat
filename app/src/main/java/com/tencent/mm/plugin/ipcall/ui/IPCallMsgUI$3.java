package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.ui.o.a;

class IPCallMsgUI$3 implements a {
    final /* synthetic */ IPCallMsgUI nKK;

    IPCallMsgUI$3(IPCallMsgUI iPCallMsgUI) {
        this.nKK = iPCallMsgUI;
    }

    public final void Xw() {
    }

    public final void Xv() {
        if (IPCallMsgUI.b(this.nKK).getCount() == 0) {
            IPCallMsgUI.a(this.nKK).setVisibility(8);
            IPCallMsgUI.c(this.nKK).setVisibility(0);
            return;
        }
        IPCallMsgUI.a(this.nKK).setVisibility(0);
        IPCallMsgUI.c(this.nKK).setVisibility(8);
    }
}
