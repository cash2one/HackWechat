package com.tencent.mm.modelstat;

import com.tencent.mm.modelstat.e.1;
import com.tencent.mm.modelstat.e.b;
import com.tencent.mm.modelstat.e.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.sdk.platformtools.x;

class e$1$1 implements a {
    boolean hQU = false;
    final /* synthetic */ b hQV;
    final /* synthetic */ c hQW;
    final /* synthetic */ String hQX;
    final /* synthetic */ String hQY;
    final /* synthetic */ 1 hQZ;

    e$1$1(1 1, b bVar, c cVar, String str, String str2) {
        this.hQZ = 1;
        this.hQV = bVar;
        this.hQW = cVar;
        this.hQX = str;
        this.hQY = str2;
    }

    public final boolean uF() {
        boolean df = m.df(ac.getContext());
        long Wp = bh.Wp();
        long a = Wp - e.a(this.hQZ.hQT);
        if (a <= ((long) e.g(this.hQZ.hQT))) {
            if (df) {
                this.hQU = false;
                return true;
            } else if (!this.hQU) {
                this.hQU = true;
                return true;
            }
        }
        x.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", new Object[]{Boolean.valueOf(this.hQU), Boolean.valueOf(df), Long.valueOf(a)});
        e.a(this.hQZ.hQT, 0);
        String ST = this.hQV.ST();
        String ST2 = this.hQW.ST();
        try {
            if (bh.ov(ST) || bh.ov(ST2)) {
                x.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", new Object[]{ST, ST2});
                g.pQN.k(13381, this.hQX + this.hQY + (!bh.ov(ST) ? ",-10011,ERROR:StopFailed." : ",-10012,ERROR:StopFailed."));
                return false;
            }
            String str = ST + ST2;
            int ceil = (int) Math.ceil(((double) str.length()) / 5400.0d);
            for (int i = 0; i < ceil; i++) {
                x.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(ceil), Integer.valueOf(str.length()), Integer.valueOf((this.hQX + this.hQY + "_" + Wp + "_" + ceil + "_" + (a > ((long) e.g(this.hQZ.hQT)) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length()))).length()), this.hQX + this.hQY + "_" + Wp + "_" + ceil + "_" + (a > ((long) e.g(this.hQZ.hQT)) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length()))});
                g.pQN.k(13381, ST);
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", new Object[]{e.getMessage()});
        }
    }
}
