package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class NetworkDiagnoseAllInOneUI$2 implements a {
    final /* synthetic */ NetworkDiagnoseAllInOneUI sfv;

    NetworkDiagnoseAllInOneUI$2(NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI) {
        this.sfv = networkDiagnoseAllInOneUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        String str;
        x.i("MicroMsg.NetworkDiagnoseAllInOneUI", "get location, isOK:%b", new Object[]{Boolean.valueOf(z)});
        NetworkDiagnoseAllInOneUI.g(this.sfv).c(NetworkDiagnoseAllInOneUI.f(this.sfv));
        ag.y(new Runnable(this) {
            final /* synthetic */ NetworkDiagnoseAllInOneUI$2 sfy;

            {
                this.sfy = r1;
            }

            public final void run() {
                NetworkDiagnoseAllInOneUI.h(this.sfy.sfv).setEnabled(true);
                if (NetworkDiagnoseAllInOneUI.i(this.sfy.sfv) != null && NetworkDiagnoseAllInOneUI.i(this.sfy.sfv).isShowing()) {
                    NetworkDiagnoseAllInOneUI.i(this.sfy.sfv).dismiss();
                }
                NetworkDiagnoseAllInOneUI.b(this.sfy.sfv, 6);
                NetworkDiagnoseAllInOneUI.b(this.sfy.sfv);
            }
        });
        NetworkDiagnoseAllInOneUI.j(this.sfv);
        if (z) {
            str = (String.valueOf(f2) + "-" + String.valueOf(f)) + "," + NetworkDiagnoseAllInOneUI.j(this.sfv);
        } else {
            x.e("MicroMsg.NetworkDiagnoseAllInOneUI", "get geolocation fail");
            str = "," + NetworkDiagnoseAllInOneUI.j(this.sfv);
        }
        g.pQN.k(14533, str);
        return false;
    }
}
