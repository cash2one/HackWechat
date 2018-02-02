package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

public class w implements a {
    public final int fyV = (w.class.hashCode() & 65535);

    public void onReady() {
    }

    public void ahY() {
    }

    public final void ahZ() {
        if (d.fM(17)) {
            onReady();
        }
    }

    public final void b(int i, int i2, Intent intent) {
        if (this.fyV == i) {
            if (i2 == -1) {
                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs download ok");
                com.tencent.mm.plugin.appbrand.task.d.lv(0);
                onReady();
            } else if (i2 == 2) {
                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs cancel loading, download in background");
                ahY();
            } else {
                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(VERSION.SDK_INT)});
                g.pQN.a(366, 8, 1, false);
                ahZ();
            }
        }
    }
}
