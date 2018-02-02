package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.plugin.notification.ui.b;
import com.tencent.mm.plugin.report.service.g;

class a$3 implements b {
    final /* synthetic */ a oUi;

    a$3(a aVar) {
        this.oUi = aVar;
    }

    public final void bgA() {
        g.pQN.h(11425, new Object[]{Integer.valueOf(this.oUi.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
        this.oUi.bgv();
        this.oUi.bgx();
        if (!this.oUi.oUb) {
            this.oUi.oUa.dismiss();
        }
    }
}
