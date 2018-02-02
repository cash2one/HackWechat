package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.j.d;

class LaunchAAUI$13 implements a<Void, d<Boolean, String, Long>> {
    final /* synthetic */ LaunchAAUI ijW;

    LaunchAAUI$13(LaunchAAUI launchAAUI) {
        this.ijW = launchAAUI;
    }

    public final /* synthetic */ Object call(Object obj) {
        x.d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", ((d) obj).get(0));
        if (LaunchAAUI.k(this.ijW) != null) {
            LaunchAAUI.k(this.ijW).dismiss();
        }
        if (((Boolean) r8.get(0)).booleanValue()) {
            LaunchAAUI.l(this.ijW);
            Toast.makeText(this.ijW, i.uJF, 1).show();
            g.pQN.h(13722, Integer.valueOf(9));
        } else {
            Toast.makeText(this.ijW, i.uJC, 1).show();
            g.pQN.h(13722, Integer.valueOf(10));
        }
        return zBS;
    }
}
