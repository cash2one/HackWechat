package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class LaunchAAUI$10 implements a<Void, Boolean> {
    final /* synthetic */ LaunchAAUI ijW;

    LaunchAAUI$10(LaunchAAUI launchAAUI) {
        this.ijW = launchAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        x.d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", (Boolean) obj);
        if (LaunchAAUI.k(this.ijW) != null) {
            LaunchAAUI.k(this.ijW).dismiss();
        }
        if (r7.booleanValue()) {
            LaunchAAUI.l(this.ijW);
            Toast.makeText(this.ijW, i.uJF, 1).show();
            g.pQN.h(13722, Integer.valueOf(4));
        } else {
            Toast.makeText(this.ijW, i.uJC, 1).show();
            g.pQN.h(13722, Integer.valueOf(5));
        }
        return zBS;
    }
}
