package com.tencent.mm.plugin.nearlife.ui;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class CheckInLifeUI$3 implements a {
    final /* synthetic */ CheckInLifeUI oQL;

    CheckInLifeUI$3(CheckInLifeUI checkInLifeUI) {
        this.oQL = checkInLifeUI;
    }

    public final void b(Addr addr) {
        x.i("MicroMsg.CheckInLifeUI", "get info %s", new Object[]{addr.toString()});
        if (bh.ov(CheckInLifeUI.a(this.oQL))) {
            CheckInLifeUI.a(this.oQL, addr.hxw);
            CheckInLifeUI.b(this.oQL).dA(CheckInLifeUI.a(this.oQL), addr.hxE);
        }
    }
}
