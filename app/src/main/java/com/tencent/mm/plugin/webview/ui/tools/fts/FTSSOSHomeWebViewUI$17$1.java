package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.17;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.Map;

class FTSSOSHomeWebViewUI$17$1 implements Runnable {
    final /* synthetic */ Bundle tAS;
    final /* synthetic */ Map tDq;
    final /* synthetic */ 17 tDr;

    FTSSOSHomeWebViewUI$17$1(17 17, Bundle bundle, Map map) {
        this.tDr = 17;
        this.tAS = bundle;
        this.tDq = map;
    }

    public final void run() {
        boolean a;
        if (this.tDr.tDo.tlx != null) {
            a = this.tDr.tDo.tlx.a(this.tAS.getString(DownloadSettingTable$Columns.TYPE, "0"), this.tAS.getString("isMostSearchBiz", "0"), this.tAS.getString("isSug", "0"), this.tAS.getString("scene", "0"), this.tAS.getString("isLocalSug", "0"), this.tDr.tDo.bTC(), this.tDr.tDo.bTE(), this.tDr.tDo.bTF(), this.tDr.tDo.bTw(), this.tDr.tDo.tDj, this.tDq);
        } else {
            a = false;
        }
        if (a) {
            this.tDr.tDo.bTy().LW(this.tDr.tDo.AR(0));
            this.tDr.tDo.tCU.Dh(7);
        }
    }
}
