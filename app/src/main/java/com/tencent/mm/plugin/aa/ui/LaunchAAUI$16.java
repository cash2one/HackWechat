package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.report.service.g;

class LaunchAAUI$16 implements a$a {
    final /* synthetic */ LaunchAAUI ijW;

    LaunchAAUI$16(LaunchAAUI launchAAUI) {
        this.ijW = launchAAUI;
    }

    public final void WO() {
        this.ijW.startActivity(new Intent(this.ijW, AAQueryListUI.class));
        if (LaunchAAUI.b(this.ijW) == a.ifI) {
            g.pQN.h(13721, Integer.valueOf(5), Integer.valueOf(1));
            return;
        }
        g.pQN.h(13721, Integer.valueOf(5), Integer.valueOf(2));
    }
}
