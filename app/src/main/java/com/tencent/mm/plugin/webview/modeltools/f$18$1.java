package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.plugin.webview.modeltools.f.18;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class f$18$1 implements Runnable {
    final /* synthetic */ String iGf;
    final /* synthetic */ i tva;
    final /* synthetic */ 18 tvb;

    f$18$1(18 18, String str, i iVar) {
        this.tvb = 18;
        this.iGf = str;
        this.tva = iVar;
    }

    public final void run() {
        x.d("MicroMsg.SubCoreTools", "webview hijack sysMsgListener");
        Map y = bi.y(this.iGf, "sysmsg");
        long j = bh.getLong((String) y.get(".sysmsg.hijackconfig.expiretime"), Long.MAX_VALUE);
        String str = ".sysmsg.hijackconfig.domainlist.domain";
        int i = 0;
        String str2 = str;
        while (true) {
            String str3;
            if (i > 0) {
                str3 = str + i;
            } else {
                str3 = str2;
            }
            i++;
            str2 = (String) y.get(str3);
            if (!bh.ov(str2)) {
                c hVar = new h();
                hVar.field_expireTime = j;
                hVar.field_host = str2;
                this.tva.b(hVar);
                str2 = str3;
            } else {
                return;
            }
        }
    }
}
