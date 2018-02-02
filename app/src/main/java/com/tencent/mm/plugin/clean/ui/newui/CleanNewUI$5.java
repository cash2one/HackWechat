package com.tencent.mm.plugin.clean.ui.newui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import org.json.JSONObject;

class CleanNewUI$5 extends c {
    final /* synthetic */ CleanNewUI lhX;

    CleanNewUI$5(CleanNewUI cleanNewUI, String str) {
        this.lhX = cleanNewUI;
        super(0, null, str);
    }

    public final void onComplete() {
        x.d("MicroMsg.CleanNewUI", "request onComplete:%s", new Object[]{this.content});
        try {
            JSONObject jSONObject = new JSONObject(this.content);
            ar.Hg();
            com.tencent.mm.z.c.CU().a(a.xqx, this.content);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
            g.pQN.a(282, 8, 1, false);
        }
    }
}
