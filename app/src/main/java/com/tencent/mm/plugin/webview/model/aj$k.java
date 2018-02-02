package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map.Entry;

public class aj$k {
    public int fMy;
    final /* synthetic */ aj tsT;
    public String ttb;
    public HashMap<String, Long> ttm = new HashMap();

    public aj$k(aj ajVar) {
        this.tsT = ajVar;
    }

    public final void aO(String str, boolean z) {
        if (bh.ov(str)) {
            x.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
        } else if (!this.ttm.containsKey(str)) {
        } else {
            if (z) {
                this.ttm.put(str, Long.valueOf(bh.Wp() - ((Long) this.ttm.get(str)).longValue()));
                return;
            }
            this.ttm.put(str, Long.valueOf(-1));
        }
    }

    public final void c(d dVar) {
        if (dVar != null) {
            int bQU = aj.bQU();
            for (Entry entry : this.ttm.entrySet()) {
                String str = (String) entry.getKey();
                long longValue = ((Long) entry.getValue()).longValue();
                g.pQN.a(32, 2, 1, true);
                if (longValue == -1) {
                    g.pQN.a(32, 13, 1, true);
                    x.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", new Object[]{str, Integer.valueOf(bQU)});
                }
                if (longValue >= 0 && longValue <= 60000) {
                    String str2 = this.ttb;
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(2);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(bQU);
                    objArr[3] = str == null ? str : str.replace(",", "!");
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(aj.bl());
                    objArr[8] = Integer.valueOf(aj.JM());
                    objArr[9] = Integer.valueOf(this.fMy);
                    objArr[10] = this.ttb;
                    aj.a(dVar, str2, objArr);
                    x.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{str, Long.valueOf(longValue), Integer.valueOf(bQU), Integer.valueOf(this.fMy), this.ttb});
                    g.pQN.a(32, 6, longValue, true);
                }
            }
        }
    }
}
