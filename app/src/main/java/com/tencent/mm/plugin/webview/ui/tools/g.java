package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    public static g tyi = new g();
    private String fqu;
    boolean hik = false;
    private int networkType;
    String rea;
    String tyj;

    private g() {
    }

    public final void eP(String str, String str2) {
        x.i("MicroMsg.WebViewReportUtil", "setting traceid " + str + ",usename " + str2);
        this.rea = str;
        this.networkType = aj.bQU();
        this.fqu = ab.UZ(str2 + bh.Wp());
        this.hik = false;
    }

    public final void AG(int i) {
        x.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", new Object[]{this.rea});
        if (!bh.ov(this.rea)) {
            d(3, "", i);
        }
    }

    public final void close() {
        x.v("MicroMsg.WebViewReportUtil", "close traceid %s", new Object[]{this.rea});
        this.hik = true;
        if (!bh.ov(this.rea)) {
            pY(4);
            this.rea = null;
        }
    }

    final void pY(int i) {
        d(i, "", 0);
    }

    final void d(int i, String str, int i2) {
        d dVar = new d();
        dVar.q("20adInfo", this.rea + ",");
        dVar.q("21optype", i + ",");
        dVar.q("22sessionId", this.fqu + ",");
        dVar.q("23currURL", this.tyj + ",");
        dVar.q("24referURL", str + ",");
        dVar.q("25errCode", i2 + ",");
        dVar.q("26networkType", this.networkType + ",");
        dVar.q("27timeStamp", bh.Wp() + ",");
        x.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[]{Integer.valueOf(i), this.fqu, this.tyj, str, Integer.valueOf(i2), Integer.valueOf(this.networkType)});
        com.tencent.mm.plugin.report.service.g.pQN.h(13791, new Object[]{dVar});
    }
}
