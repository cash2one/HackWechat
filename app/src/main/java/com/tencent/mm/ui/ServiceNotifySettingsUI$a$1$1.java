package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ServiceNotifySettingsUI.a;
import com.tencent.mm.ui.ServiceNotifySettingsUI.a.1;

class ServiceNotifySettingsUI$a$1$1 implements OnClickListener {
    final /* synthetic */ String gIT;
    final /* synthetic */ 1 xMB;

    ServiceNotifySettingsUI$a$1$1(1 1, String str) {
        this.xMB = 1;
        this.gIT = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 0;
        while (i2 < a.a(this.xMB.xMA).size()) {
            a.a aVar = (a.a) a.a(this.xMB.xMA).get(i2);
            if (aVar == null || !this.gIT.equals(aVar.username)) {
                i2++;
            } else {
                a.b(this.xMB.xMA).add(a.a(this.xMB.xMA).remove(i2));
                this.xMB.xMA.notifyDataSetChanged();
                WxaAttributes qK = ((b) g.h(b.class)).qK(this.gIT);
                String str = qK == null ? "" : qK.field_appId;
                if (this.xMB.xMz == 1) {
                    x.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", new Object[]{Integer.valueOf(13798), Integer.valueOf(4), str, a.c(this.xMB.xMA)});
                    com.tencent.mm.plugin.report.service.g.pQN.h(13798, new Object[]{Integer.valueOf(4), str, Integer.valueOf(0), a.c(this.xMB.xMA), Long.valueOf(bh.Wo())});
                    return;
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(13796, new Object[]{Integer.valueOf(12), str, "", Integer.valueOf(0), Long.valueOf(bh.Wo())});
                return;
            }
        }
    }
}
