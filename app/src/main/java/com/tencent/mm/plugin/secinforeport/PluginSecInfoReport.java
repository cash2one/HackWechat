package com.tencent.mm.plugin.secinforeport;

import android.os.HandlerThread;
import com.tencent.mm.a.h;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.normsg.a;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public class PluginSecInfoReport extends f implements b {
    private static HandlerThread qeW = null;
    private static af qeX = null;

    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(d.class);
        dependsOn(b.class);
        dependsOn(a.class);
    }

    public void configure(g gVar) {
        com.tencent.mm.plugin.secinforeport.a.d.a(c.qfa);
        com.tencent.mm.plugin.secinforeport.a.a.a(a.qeU);
    }

    public void execute(g gVar) {
        if (qeW == null) {
            try {
                HandlerThread Wf = e.Wf("SIRWorker");
                qeW = Wf;
                Wf.start();
                qeX = new af(qeW.getLooper());
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.PSIR", th, "[tomys] unexpected exception.", new Object[0]);
            }
        }
        com.tencent.mm.sdk.b.a.xef.a(new 1(this));
        com.tencent.mm.sdk.b.a.xef.a(new 2(this));
        ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a(this) {
            final /* synthetic */ PluginSecInfoReport qeY;

            {
                this.qeY = r1;
            }

            public final void a(i.f fVar, i.g gVar, boolean z) {
                this.qeY.reportSecurityInfoAsync(z ? 0 : 540999680);
            }

            public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
                this.qeY.reportSecurityInfoAsync(540999681);
            }
        });
    }

    private void reportSecurityInfoAsync(final int i) {
        if (qeX == null) {
            x.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
        } else {
            qeX.post(new Runnable(this) {
                final /* synthetic */ PluginSecInfoReport qeY;

                public final void run() {
                    try {
                        if (com.tencent.mm.plugin.secinforeport.a.d.qfi.G(1, 86400000)) {
                            boolean z;
                            int i = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getInt("DisableRiskScanSdkProb", 0);
                            int i2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getInt("DisableInstalledPkgInfoReportProb", 0);
                            com.tencent.mm.kernel.g.Dh();
                            int aJ = h.aJ(com.tencent.mm.kernel.a.Cg(), 101);
                            i = (i <= 0 || aJ < 0 || aJ > i) ? 0 : 1;
                            if (i2 <= 0 || aJ < 0 || aJ > i2) {
                                i2 = 0;
                            } else {
                                i2 = 1;
                            }
                            com.tencent.mm.plugin.normsg.a.d dVar = com.tencent.mm.plugin.normsg.a.d.oSu;
                            if (i == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            String t = dVar.t(z, i2 == 0);
                            com.tencent.mm.plugin.secinforeport.a.d.qfi.IX(t);
                            com.tencent.mm.plugin.secinforeport.a.d.qfi.bX(t, i);
                        }
                        if (com.tencent.mm.plugin.secinforeport.a.d.qfi.G(2, 129600000)) {
                            com.tencent.mm.plugin.secinforeport.a.d.qfi.bqp();
                        }
                    } catch (Throwable th) {
                        x.printErrStackTrace("MicroMsg.PSIR", th, "unexpected exception was thrown.", new Object[0]);
                    }
                }
            });
        }
    }
}
