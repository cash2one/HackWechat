package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map.Entry;

public class aj$e {
    public int fMy;
    public String jIW = "";
    final /* synthetic */ aj tsT;
    public HashMap<String, Long> tsY = new HashMap();
    public HashMap<String, Long> tsZ = new HashMap();
    public boolean tta = true;
    public String ttb;

    public aj$e(aj ajVar) {
        this.tsT = ajVar;
    }

    public final void c(d dVar) {
        if (dVar != null) {
            String str;
            long longValue;
            String str2;
            Object[] objArr;
            int bQU = aj.bQU();
            for (Entry entry : this.tsY.entrySet()) {
                str = (String) entry.getKey();
                longValue = ((Long) entry.getValue()).longValue();
                if (longValue >= 0 && longValue <= 180000) {
                    str2 = this.ttb;
                    objArr = new Object[11];
                    objArr[0] = Integer.valueOf(5);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(bQU);
                    if (str != null) {
                        str = str.replace(",", "!");
                    }
                    objArr[3] = str;
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(aj.bl());
                    objArr[8] = Integer.valueOf(aj.JM());
                    objArr[9] = Integer.valueOf(this.fMy);
                    objArr[10] = this.ttb;
                    aj.a(dVar, str2, objArr);
                    if (aj.bl() == 1) {
                        g.pQN.a(32, 18, 1, true);
                        g.pQN.a(32, 19, longValue, true);
                    }
                    g.pQN.a(32, 8, 1, true);
                    g.pQN.a(32, 9, longValue, true);
                    x.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{Long.valueOf(longValue), Integer.valueOf(bQU), Integer.valueOf(aj.bl()), Integer.valueOf(aj.JM()), Integer.valueOf(this.fMy), this.ttb});
                } else {
                    return;
                }
            }
            for (Entry entry2 : this.tsZ.entrySet()) {
                str = (String) entry2.getKey();
                longValue = ((Long) entry2.getValue()).longValue();
                if (longValue >= 0 && longValue <= 180000) {
                    str2 = this.ttb;
                    objArr = new Object[11];
                    objArr[0] = Integer.valueOf(6);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(bQU);
                    if (str != null) {
                        str = str.replace(",", "!");
                    }
                    objArr[3] = str;
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(aj.bl());
                    objArr[8] = Integer.valueOf(aj.JM());
                    objArr[9] = Integer.valueOf(this.fMy);
                    objArr[10] = this.ttb;
                    aj.a(dVar, str2, objArr);
                    if (aj.bl() == 1) {
                        g.pQN.a(32, 20, 1, true);
                        g.pQN.a(32, 21, longValue, true);
                    }
                    g.pQN.a(32, 10, 1, true);
                    g.pQN.a(32, 11, longValue, true);
                    x.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{Long.valueOf(longValue), Integer.valueOf(bQU), Integer.valueOf(aj.bl()), Integer.valueOf(aj.JM()), Integer.valueOf(this.fMy), this.ttb});
                } else {
                    return;
                }
            }
        }
    }
}
