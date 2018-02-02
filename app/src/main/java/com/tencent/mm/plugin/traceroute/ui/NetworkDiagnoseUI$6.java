package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.traceroute.b.a.b;
import com.tencent.mm.plugin.traceroute.b.a.d;
import com.tencent.mm.plugin.traceroute.b.a.j;
import com.tencent.mm.plugin.traceroute.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bd.a;
import com.tencent.mm.z.q;

class NetworkDiagnoseUI$6 implements a {
    final /* synthetic */ NetworkDiagnoseUI sfP;

    NetworkDiagnoseUI$6(NetworkDiagnoseUI networkDiagnoseUI) {
        this.sfP = networkDiagnoseUI;
    }

    public final void a(e eVar) {
        if (eVar != null) {
            NetworkDiagnoseUI.a(this.sfP, new com.tencent.mm.plugin.traceroute.b.a(q.FS()));
            NetworkDiagnoseUI.d(this.sfP).b(eVar.getIPsString(true), true);
            NetworkDiagnoseUI.d(this.sfP).b(eVar.getIPsString(false), false);
            NetworkDiagnoseUI.d(this.sfP).seV = new d(this) {
                final /* synthetic */ NetworkDiagnoseUI$6 sfQ;

                {
                    this.sfQ = r1;
                }

                public final void bFx() {
                    NetworkDiagnoseUI.i(this.sfQ.sfP).sendEmptyMessageDelayed(2, 500);
                }
            };
            NetworkDiagnoseUI.d(this.sfP).seU = new com.tencent.mm.plugin.traceroute.b.a.e(this) {
                final /* synthetic */ NetworkDiagnoseUI$6 sfQ;

                {
                    this.sfQ = r1;
                }

                public final void bFy() {
                    NetworkDiagnoseUI.i(this.sfQ.sfP).sendEmptyMessageDelayed(1, 500);
                }
            };
            NetworkDiagnoseUI.d(this.sfP).seX = new b(this) {
                final /* synthetic */ NetworkDiagnoseUI$6 sfQ;

                {
                    this.sfQ = r1;
                }

                public final void bFv() {
                    NetworkDiagnoseUI.i(this.sfQ.sfP).sendEmptyMessage(3);
                }
            };
            NetworkDiagnoseUI.d(this.sfP).seW = new 4(this);
            com.tencent.mm.plugin.traceroute.b.a d = NetworkDiagnoseUI.d(this.sfP);
            if (d.seT == null || d.seT.size() == 0) {
                x.e("MicroMsg.MMTraceRoute", "no iplist");
            } else {
                if (com.tencent.mm.plugin.traceroute.b.a.seP == null) {
                    com.tencent.mm.plugin.traceroute.b.a.seP = new c();
                }
                com.tencent.mm.sdk.f.e.post(new j(d, (byte) 0), "MMTraceRoute_start");
            }
            NetworkDiagnoseUI.j(this.sfP).J(1200, 1200);
        }
    }
}
