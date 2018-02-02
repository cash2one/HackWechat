package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class LaunchAAUI$6 implements OnClickListener {
    final /* synthetic */ LaunchAAUI ijW;
    final /* synthetic */ List ijX;

    LaunchAAUI$6(LaunchAAUI launchAAUI, List list) {
        this.ijW = launchAAUI;
        this.ijX = list;
    }

    public final void onClick(View view) {
        this.ijW.Xa();
        this.ijW.aWs();
        LaunchAAUI.a(this.ijW, this.ijX);
    }
}
