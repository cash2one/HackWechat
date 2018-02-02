package com.tencent.mm.plugin.offline.ui;

import android.os.Looper;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<rd> {
    private af mHandler;

    public d() {
        this.mHandler = new af(Looper.getMainLooper());
        this.xen = rd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rd rdVar = (rd) bVar;
        if (g.Dh().Cy() && (rdVar instanceof rd)) {
            x.i("MicroMsg.SyncOfflineTokenListener", "SyncOfflineTokenListener -> updateToken()");
            boolean z = rdVar.fIS.fIT;
            boolean z2 = rdVar.fIS.scene == 1;
            if (z2) {
                com.tencent.mm.plugin.report.service.g.pQN.a(135, 25, 1, true);
            }
            if (z) {
                this.mHandler.postDelayed(new 1(this, z2), 10000);
            } else {
                k.bgX();
                k.bha().hd(z2);
            }
        }
        return false;
    }
}
