package com.tencent.mm.plugin.welab.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.aj.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class b implements com.tencent.mm.plugin.welab.a.a.b {
    public final void e(Activity activity, String str) {
        if (g.zM(0)) {
            Intent QM = com.tencent.mm.bc.b.QM();
            QM.putExtra("ftsbizscene", 20);
            Map b = com.tencent.mm.bc.b.b(20, true, 0);
            QM.putExtra("ftsneedkeyboard", true);
            QM.putExtra("rawUrl", com.tencent.mm.bc.b.r(b));
            d.b(activity, "webview", ".ui.tools.fts.FTSSearchOneSearchWebViewUI", QM);
            return;
        }
        x.e("MicroMsg.FTS.SearchOneSearchOpener", "fts h5 template not avail");
    }

    public final String bVC() {
        return h.NT("discoverSearchEntry").optString("labIcon");
    }

    public final String bVD() {
        String optString = h.NT("discoverSearchEntry").optString("wording");
        if (bh.ov(optString)) {
            return ac.getContext().getString(R.l.ehx);
        }
        return optString;
    }
}
