package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.y;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class LaunchAAUI$11 implements a {
    final /* synthetic */ LaunchAAUI ijW;

    LaunchAAUI$11(LaunchAAUI launchAAUI) {
        this.ijW = launchAAUI;
    }

    public final void aW(Object obj) {
        x.i("MicroMsg.LaunchAAUI", "onInterrupt: %s", obj);
        if (LaunchAAUI.k(this.ijW) != null) {
            LaunchAAUI.k(this.ijW).dismiss();
        }
        if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
            Toast.makeText(this.ijW, obj.toString(), 1).show();
        } else if (obj == null || !(obj instanceof y)) {
            Toast.makeText(this.ijW, i.uJC, 1).show();
        } else {
            h.a(this.ijW.mController.xIM, (y) obj);
        }
        g.pQN.h(13722, Integer.valueOf(10));
    }
}
