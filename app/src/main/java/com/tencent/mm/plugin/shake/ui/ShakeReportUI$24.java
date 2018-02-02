package com.tencent.mm.plugin.shake.ui;

import com.tencent.mm.g.a.dk;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.d.a.h.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class ShakeReportUI$24 extends c<dk> {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$24(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
        this.xen = dk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dk dkVar = (dk) bVar;
        String str = dkVar.frY.frW;
        int i = dkVar.frY.frZ;
        int i2 = dkVar.frY.fsa;
        String str2 = dkVar.frY.fsd;
        double d = dkVar.frY.fsc;
        int i3 = dkVar.frY.fse;
        if (!ShakeReportUI.e(this.qsi).containsKey(str + "," + i + "," + i2)) {
            a aVar = new a();
            aVar.ned = str;
            aVar.hLU = dkVar.frY.fsb;
            aVar.major = i;
            aVar.minor = i2;
            aVar.qpP = str2;
            aVar.qpQ = d;
            aVar.qpR = i3;
            ShakeReportUI.e(this.qsi).put(str + "," + i + "," + i2, aVar);
            if (dkVar.frY.fsb >= 0.0d && ShakeReportUI.bsy().size() > 0) {
                i3 = 0;
                while (i3 < ShakeReportUI.bsy().size()) {
                    a aVar2 = (a) ShakeReportUI.bsy().get(i3);
                    if (dkVar.frY.fsb >= aVar2.hLU) {
                        if (i3 == ShakeReportUI.bsy().size() - 1 && dkVar.frY.fsb > aVar2.hLU) {
                            ShakeReportUI.bsy().add(aVar);
                            break;
                        }
                        i3++;
                    } else {
                        ShakeReportUI.bsy().add(i3, aVar);
                        break;
                    }
                }
            }
            ShakeReportUI.bsy().add(aVar);
            if (ShakeReportUI.e(this.qsi).size() == 1 && !ShakeReportUI.f(this.qsi)) {
                ShakeReportUI.a(this.qsi, System.currentTimeMillis() - ShakeReportUI.g(this.qsi));
                g.pQN.h(11497, String.valueOf((int) (((double) (ShakeReportUI.g(this.qsi) / 1000)) + 0.5d)), Integer.valueOf(0), Integer.valueOf((int) ShakeReportUI.g(this.qsi)));
                ShakeReportUI.a(this.qsi, 0);
                this.qsi.runOnUiThread(new 1(this));
            }
        }
        x.i("MicroMsg.ShakeReportUI", "result iBeacon = %s,beaconMap.size:%d", str + "," + i + "," + i2, Integer.valueOf(ShakeReportUI.e(this.qsi).size()));
        return false;
    }
}
