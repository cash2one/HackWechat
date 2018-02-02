package com.tencent.mm.plugin.search.ui;

import android.content.Intent;
import com.tencent.mm.bc.g;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.search.ui.h.b;
import com.tencent.mm.protocal.c.bdh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.Map;

class FTSMainUI$9 implements b {
    final /* synthetic */ FTSMainUI qdk;

    FTSMainUI$9(FTSMainUI fTSMainUI) {
        this.qdk = fTSMainUI;
    }

    public final void a(bdh com_tencent_mm_protocal_c_bdh, String str, int i) {
        String str2 = this.qdk.fDj;
        if (com_tencent_mm_protocal_c_bdh.nhx == 1) {
            FTSMainUI.a(this.qdk, this.qdk.fDj);
            this.qdk.fDj = com_tencent_mm_protocal_c_bdh.wJs;
            Map hashMap = new HashMap();
            hashMap.put("prefixSug", FTSMainUI.d(this.qdk));
            hashMap.put("sugId", str);
            hashMap.put("sceneActionType", "6");
            FTSMainUI.a(this.qdk, hashMap);
        } else if (com_tencent_mm_protocal_c_bdh.nhx == 4 && !bh.ov(com_tencent_mm_protocal_c_bdh.nfg)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", com_tencent_mm_protocal_c_bdh.nfg);
            intent.putExtra("convertActivityFromTranslucent", false);
            d.b(ac.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
        g.b(str2, str, i, com_tencent_mm_protocal_c_bdh.wJs);
    }
}
