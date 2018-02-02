package com.tencent.mm.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class LauncherUIBottomTabView$2 extends af {
    final /* synthetic */ LauncherUIBottomTabView xHG;

    LauncherUIBottomTabView$2(LauncherUIBottomTabView launcherUIBottomTabView) {
        this.xHG = launcherUIBottomTabView;
    }

    public final void handleMessage(Message message) {
        x.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUIBottomTabView.d(this.xHG).oW(0);
    }
}
