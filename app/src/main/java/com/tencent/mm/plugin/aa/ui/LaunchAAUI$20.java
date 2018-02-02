package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class LaunchAAUI$20 implements a<Void, d> {
    final /* synthetic */ LaunchAAUI ijW;

    LaunchAAUI$20(LaunchAAUI launchAAUI) {
        this.ijW = launchAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        x.i("MicroMsg.LaunchAAUI", "fetch operation data finish");
        if (dVar != null) {
            LaunchAAUI.a(this.ijW, dVar);
            if (!(bh.ov(LaunchAAUI.d(this.ijW).igr) || bh.ov(LaunchAAUI.d(this.ijW).igq))) {
                LaunchAAUI.a(this.ijW, LaunchAAUI.d(this.ijW).igr, LaunchAAUI.d(this.ijW).igq);
            }
        }
        return zBS;
    }
}
