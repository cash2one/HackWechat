package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

class n$2 implements Runnable {
    final /* synthetic */ String gBF;
    final /* synthetic */ long hAU;
    final /* synthetic */ n hUY;
    final /* synthetic */ String[] hUZ;
    final /* synthetic */ String hVa;
    final /* synthetic */ int hVb;
    final /* synthetic */ String hVc;
    final /* synthetic */ String hVd;
    final /* synthetic */ long hVe;
    final /* synthetic */ int hVf;
    final /* synthetic */ int hVg;
    final /* synthetic */ String hVh;
    final /* synthetic */ String heS;

    n$2(n nVar, String str, String[] strArr, String str2, String str3, int i, String str4, String str5, long j, long j2, int i2, int i3, String str6) {
        this.hUY = nVar;
        this.gBF = str;
        this.hUZ = strArr;
        this.heS = str2;
        this.hVa = str3;
        this.hVb = i;
        this.hVc = str4;
        this.hVd = str5;
        this.hAU = j;
        this.hVe = j2;
        this.hVf = i2;
        this.hVg = i3;
        this.hVh = str6;
    }

    public final void run() {
        a Js = d.Js(this.gBF);
        if (Js == null) {
            x.w("MicroMsg.SubCoreMediaRpt", "get media info is null. %s", new Object[]{this.gBF});
            return;
        }
        int bN = e.bN(this.gBF);
        String str = null;
        if (this.hUZ != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : this.hUZ) {
                stringBuffer.append(append).append("|");
            }
            str = stringBuffer.toString();
        }
        int eR = an.eR(ac.getContext());
        g.MK();
        String kD = b.kD(this.gBF);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(this.heS).append(",").append(this.hVa).append(",");
        stringBuffer2.append(this.hVb).append(",").append(this.hVc).append(",");
        stringBuffer2.append(this.hVd).append(",").append(eR).append(",");
        stringBuffer2.append(kD).append(",").append(this.hAU).append(",");
        stringBuffer2.append(this.hVe).append(",").append(bN).append(",");
        stringBuffer2.append(Js.mxs).append(",").append(Js.videoBitrate / 1000).append(",");
        stringBuffer2.append(Js.huc / 1000).append(",").append(Js.owg).append(",");
        stringBuffer2.append(Js.width).append(",").append(Js.height).append(",");
        stringBuffer2.append(str).append(",").append(Js.qsT).append(",");
        stringBuffer2.append(this.hVf).append(",").append(this.hVg).append(",");
        stringBuffer2.append(this.hVh);
        x.i("MicroMsg.SubCoreMediaRpt", "download video rpt %s ", new Object[]{stringBuffer2.toString()});
        com.tencent.mm.plugin.report.service.g.pQN.k(13795, stringBuffer2.toString());
    }
}
