package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class ExdeviceProfileUI$30 implements c {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$30(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final void a(n nVar) {
        if (ExdeviceProfileUI.x(this.lVZ)) {
            nVar.f(1, this.lVZ.getString(R.l.edw));
        } else {
            nVar.f(4, this.lVZ.getString(R.l.edA));
        }
    }
}
