package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements Runnable {
    final /* synthetic */ Activity oZ;
    final /* synthetic */ int xGI;
    final /* synthetic */ int xGJ;

    k$1(Activity activity, int i, int i2) {
        this.oZ = activity;
        this.xGI = i;
        this.xGJ = i2;
    }

    public final void run() {
        Activity activity = this.oZ;
        int i = this.xGI;
        int i2 = this.xGJ;
        x.i("MicroMsg.LauncherUI.HomeUtil", "clickFlowStat index:%d op:%d %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), t.Ws()});
        if (i2 >= 0) {
            String str = "MainUI";
            if (i2 == 1) {
                str = "AddressUI";
            }
            if (i2 == 2) {
                str = "FindMoreFriendUI";
            }
            if (i2 == 3) {
                str = "MoreTabUI";
            }
            d.b(i, str, ((activity.hashCode() / 16) * 16) + i2);
        }
    }
}
