package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.platformtools.x;

class HomeUI$19 implements Runnable {
    final /* synthetic */ HomeUI xGv;

    HomeUI$19(HomeUI homeUI) {
        this.xGv = homeUI;
    }

    public final void run() {
        x.d("MicroMsg.LauncherUI.HomeUI", "onMainTabCreate, send refresh broadcast");
        HomeUI.d(this.xGv).sendBroadcast(new Intent(ConstantsAPI.ACTION_REFRESH_WXAPP));
    }

    public final String toString() {
        return super.toString() + "|sendBroadcast";
    }
}
