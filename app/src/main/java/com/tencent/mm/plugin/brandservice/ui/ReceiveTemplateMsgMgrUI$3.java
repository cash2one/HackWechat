package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.plugin.brandservice.a.l;
import com.tencent.mm.z.ar;

class ReceiveTemplateMsgMgrUI$3 implements Runnable {
    final /* synthetic */ ReceiveTemplateMsgMgrUI kGN;

    ReceiveTemplateMsgMgrUI$3(ReceiveTemplateMsgMgrUI receiveTemplateMsgMgrUI) {
        this.kGN = receiveTemplateMsgMgrUI;
    }

    public final void run() {
        if (ReceiveTemplateMsgMgrUI.a(this.kGN)) {
            ReceiveTemplateMsgMgrUI.b(this.kGN);
            ar.CG().a(new l(ReceiveTemplateMsgMgrUI.c(this.kGN), ReceiveTemplateMsgMgrUI.asA()), 0);
        }
    }
}
