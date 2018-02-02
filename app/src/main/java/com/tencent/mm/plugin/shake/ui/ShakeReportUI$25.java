package com.tencent.mm.plugin.shake.ui;

import android.os.Build.VERSION;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bi;

class ShakeReportUI$25 extends c<dq> {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$25(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
        this.xen = dq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dq dqVar = (dq) bVar;
        x.d("MicroMsg.ShakeReportUI", "ExDeviceOnBluetoothStateChangeEvent = %s", Integer.valueOf(dqVar.fsn.fso));
        boolean hasSystemFeature = this.qsi.mController.xIM.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (dqVar.fsn.fso == 10 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
            ShakeReportUI.i(this.qsi);
        } else if (dqVar.fsn.fso == 12) {
            if (VERSION.SDK_INT < 18 || !hasSystemFeature) {
                ShakeReportUI.a(this.qsi, 1);
            } else {
                ShakeReportUI.j(this.qsi);
                ShakeReportUI.a(this.qsi, 0);
            }
            bi HQ = bi.HQ();
            String ou = bh.ou(HQ.hhx);
            String ou2 = bh.ou(HQ.hhw);
            int i = hasSystemFeature ? 1 : 0;
            if (ShakeReportUI.k(this.qsi)) {
                g.pQN.h(13139, ou, ou2, Integer.valueOf(1), Integer.valueOf(ShakeReportUI.l(this.qsi)), Integer.valueOf(1), Integer.valueOf(i));
            } else {
                g.pQN.h(13139, ou, ou2, Integer.valueOf(0), Integer.valueOf(ShakeReportUI.l(this.qsi)), Integer.valueOf(1), Integer.valueOf(i));
            }
            if (ShakeReportUI.m(this.qsi) && ShakeReportUI.k(this.qsi) && !ShakeReportUI.f(this.qsi) && ShakeReportUI.n(this.qsi) < 4) {
                this.qsi.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ShakeReportUI$25 qsn;

                    {
                        this.qsn = r1;
                    }

                    public final void run() {
                        ShakeReportUI.h(this.qsn.qsi);
                    }
                });
            }
        }
        return false;
    }
}
