package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.bc.g;
import com.tencent.mm.plugin.aj.a.f;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.16;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

class FTSSOSHomeWebViewUI$16$1 implements Runnable {
    final /* synthetic */ int icG;
    final /* synthetic */ Bundle tAS;
    final /* synthetic */ 16 tDp;

    FTSSOSHomeWebViewUI$16$1(16 16, int i, Bundle bundle) {
        this.tDp = 16;
        this.icG = i;
        this.tAS = bundle;
    }

    public final void run() {
        boolean z = false;
        if (FTSSOSHomeWebViewUI.k(this.tDp.tDo) != null) {
            Map hashMap = new HashMap();
            hashMap.put("isHomePage", "0");
            if (this.icG == 0) {
                hashMap.put("isHomePage", "1");
            } else if (this.icG == 1) {
                hashMap.put("isMostSearchBiz", this.tAS.getString("isMostSearchBiz", "0"));
            } else {
                hashMap.put("isHomePage", "0");
            }
            if (!bh.ov(this.tDp.tDo.bTC())) {
                hashMap.put("query", this.tDp.tDo.bTC());
            }
            z = FTSSOSHomeWebViewUI.l(this.tDp.tDo).a(this.tAS.getString("scene", "0"), this.tAS.getString(DownloadSettingTable$Columns.TYPE, "0"), this.tAS.getString("isSug", "0"), this.tAS.getString("isLocalSug", "0"), this.tDp.tDo.bPL(), hashMap, null);
            if (!TextUtils.isEmpty(this.tDp.tDo.bTE())) {
                f.a(this.tDp.tDo.scene, this.tDp.tDo.fqu, this.tDp.tDo.tjs, this.tDp.tDo.bTE(), this.tDp.tDo.tCA);
            }
        }
        if (z) {
            this.tDp.tDo.bTy().LW(FTSSOSHomeWebViewUI.f(this.tDp.tDo, this.icG));
            g.a(this.icG, this.tDp.tDo.tCz, FTSSOSHomeWebViewUI.m(this.tDp.tDo), FTSSOSHomeWebViewUI.a(this.tDp.tDo).bTP());
            FTSSOSHomeWebViewUI.a(this.tDp.tDo).Dh(7);
        }
    }
}
