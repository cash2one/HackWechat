package com.tencent.mm.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class LauncherUITabView$2 extends af {
    final /* synthetic */ LauncherUITabView xHV;

    LauncherUITabView$2(LauncherUITabView launcherUITabView) {
        this.xHV = launcherUITabView;
    }

    public final void handleMessage(Message message) {
        x.v("MicroMsg.LauncherUITabView", "onMainTabClick");
        LauncherUITabView.d(this.xHV).oW(0);
    }
}
