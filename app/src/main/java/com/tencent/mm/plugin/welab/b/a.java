package com.tencent.mm.plugin.welab.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class a implements b {
    public final void e(Activity activity, String str) {
        if (g.zM(0)) {
            String optString = h.NT("discoverRecommendEntry").optString("wording");
            if (bh.ov(optString)) {
                x.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
                return;
            }
            Intent QM = com.tencent.mm.bc.b.QM();
            QM.putExtra("ftsbizscene", 21);
            QM.putExtra("ftsQuery", optString);
            QM.putExtra("title", optString);
            QM.putExtra("isWebwx", optString);
            QM.putExtra("ftscaneditable", false);
            Map b = com.tencent.mm.bc.b.b(21, false, 2);
            b.put("query", optString);
            b.put("sceneActionType", "2");
            QM.putExtra("rawUrl", com.tencent.mm.bc.b.a(b, 1));
            com.tencent.mm.sdk.b.b kwVar = new kw();
            kwVar.fCe.scene = 0;
            com.tencent.mm.sdk.b.a.xef.m(kwVar);
            d.b(activity, "webview", ".ui.tools.fts.FTSWebViewUI", QM);
            com.tencent.mm.bc.g.u(21, optString);
            return;
        }
        x.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
    }

    public final String bVC() {
        return h.NT("discoverRecommendEntry").optString("labIcon");
    }

    public final String bVD() {
        String optString = h.NT("discoverRecommendEntry").optString("wording");
        if (bh.ov(optString)) {
            return ac.getContext().getString(R.l.ehx);
        }
        return optString;
    }
}
