package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.26;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class ExdeviceProfileUI$26$1 implements c {
    final /* synthetic */ 26 lWh;

    ExdeviceProfileUI$26$1(26 26) {
        this.lWh = 26;
    }

    public final void a(n nVar) {
        if (!bh.ov(this.lWh.lVZ.lOU)) {
            nVar.f(5, this.lWh.lVZ.getString(R.l.edx));
        }
        nVar.f(3, this.lWh.lVZ.getString(R.l.edu));
    }
}
