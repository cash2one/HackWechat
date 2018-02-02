package com.tencent.mm.plugin.notification.a;

import com.tencent.mm.k.f;
import com.tencent.mm.plugin.notification.a.a.1;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class a$1$1 implements Runnable {
    final /* synthetic */ String oTQ;
    final /* synthetic */ 1 oTR;

    a$1$1(1 1, String str) {
        this.oTR = 1;
        this.oTQ = str;
    }

    public final void run() {
        int i = 0;
        final int zU = f.zU();
        ar.Hg();
        x WO = c.EY().WO(this.oTQ);
        final boolean AI = WO == null ? false : WO.AI();
        if (!AI) {
            i = f.eT(this.oTQ);
        }
        ag.y(new Runnable(this) {
            final /* synthetic */ a$1$1 oTV;

            public final void run() {
                ar.getNotification().fl(zU);
                if (!AI) {
                    ar.getNotification().v(this.oTV.oTQ, i);
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", new Object[]{Integer.valueOf(zU), Integer.valueOf(i), Boolean.valueOf(AI)});
                e.post(new 1(this), "NotificationObserver");
            }
        });
    }
}
