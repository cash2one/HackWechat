package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Pair;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class e$1 implements Runnable {
    final /* synthetic */ int hLI;
    final /* synthetic */ boolean hQO;
    final /* synthetic */ float hQP;
    final /* synthetic */ float hQQ;
    final /* synthetic */ boolean hQR;
    final /* synthetic */ int hQS;
    final /* synthetic */ e hQT;

    e$1(e eVar, boolean z, float f, float f2, int i, boolean z2, int i2) {
        this.hQT = eVar;
        this.hQO = z;
        this.hQP = f;
        this.hQQ = f2;
        this.hLI = i;
        this.hQR = z2;
        this.hQS = i2;
    }

    public final void run() {
        try {
            if (g.Dh().Cy()) {
                g.Dh();
                if (!a.Cs()) {
                    long Wp = bh.Wp();
                    if (e.a(this.hQT) == 0 || Wp - e.a(this.hQT) >= 1800000) {
                        List b;
                        Pair pair;
                        if (this.hQO) {
                            b = e.b(this.hQT);
                        } else {
                            Object c = e.c(this.hQT);
                        }
                        int i = 0;
                        while (i < b.size()) {
                            if (e.o(this.hQP, ((Float) ((Pair) b.get(i)).first).floatValue()) && e.o(this.hQQ, ((Float) ((Pair) b.get(i)).second).floatValue())) {
                                pair = (Pair) b.get(i);
                                break;
                            }
                            i++;
                        }
                        pair = null;
                        if (pair == null) {
                            x.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
                            return;
                        }
                        int i2;
                        e.a(this.hQT, Wp);
                        StringBuilder stringBuilder = new StringBuilder();
                        g.Dh();
                        String stringBuilder2 = stringBuilder.append(new o(a.Cg()).toString()).append("_").append(e.a(this.hQT)).toString();
                        StringBuilder append = new StringBuilder().append(pair.first).append(",").append(pair.second).append(",").append(this.hLI).append(",");
                        int i3 = this.hQR ? 1 : 2;
                        if (this.hQO) {
                            i2 = 10;
                        } else {
                            i2 = 20;
                        }
                        String stringBuilder3 = append.append(i2 + i3).append(",").append(this.hQP).append(",").append(this.hQQ).append(",0,").append(this.hQS).append(",").append(e.a(this.hQT)).append(",").toString();
                        e$c com_tencent_mm_modelstat_e_c = new e$c(this.hQT);
                        Context context = ac.getContext();
                        i3 = e.d(this.hQT);
                        int e = e.e(this.hQT);
                        if (com_tencent_mm_modelstat_e_c.bni == null) {
                            com_tencent_mm_modelstat_e_c.bni = (WifiManager) context.getSystemService("wifi");
                        }
                        com_tencent_mm_modelstat_e_c.hRn = i3;
                        com_tencent_mm_modelstat_e_c.hQL = e;
                        com_tencent_mm_modelstat_e_c.startTime = bh.Wp();
                        com_tencent_mm_modelstat_e_c.hRo = true;
                        com_tencent_mm_modelstat_e_c.thread.start();
                        b bVar = new b(this.hQT);
                        if (bVar.u(ac.getContext(), e.f(this.hQT))) {
                            g.Dk();
                            new ak(g.Dm().oAt.getLooper(), new 1(this, bVar, com_tencent_mm_modelstat_e_c, stringBuilder3, stringBuilder2), true).J(3000, 3000);
                            return;
                        }
                        x.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", new Object[]{Boolean.valueOf(true), Boolean.valueOf(bVar.u(ac.getContext(), e.f(this.hQT)))});
                        bVar.ST();
                        com_tencent_mm_modelstat_e_c.ST();
                        com.tencent.mm.plugin.report.service.g.pQN.k(13381, stringBuilder3 + stringBuilder2 + ",-10002,ERROR:StartFailed.");
                        return;
                    }
                    x.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", new Object[]{Long.valueOf(Wp - e.a(this.hQT))});
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", new Object[]{e2.getMessage()});
        }
    }
}
