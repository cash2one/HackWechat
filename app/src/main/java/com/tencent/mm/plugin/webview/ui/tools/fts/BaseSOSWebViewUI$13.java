package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mm.plugin.aj.a.f;
import com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;

class BaseSOSWebViewUI$13 implements Runnable {
    final /* synthetic */ BaseSOSWebViewUI tCm;
    final /* synthetic */ c tCq;

    BaseSOSWebViewUI$13(BaseSOSWebViewUI baseSOSWebViewUI, c cVar) {
        this.tCm = baseSOSWebViewUI;
        this.tCq = cVar;
    }

    public final void run() {
        if (BaseSOSWebViewUI.a(this.tCm) != null) {
            this.tCm.bTs();
            int i = this.tCm.tCA;
            this.tCm.tCA = this.tCq.type;
            this.tCm.bTt();
            Bundle bundle = new Bundle();
            bundle.putInt(DownloadSettingTable$Columns.TYPE, this.tCm.tCA);
            bundle.putBoolean("isHomePage", true);
            bundle.putInt("scene", this.tCm.aRr());
            try {
                Bundle o = BaseSOSWebViewUI.b(this.tCm).o(4, bundle);
                Map hashMap = new HashMap();
                hashMap.put("isBackButtonClick", "1");
                hashMap.put("custom", this.tCm.bTE());
                if (this.tCm.tCA != i) {
                    BaseSOSWebViewUI.c(this.tCm).a(o.getString("scene", "0"), o.getString(DownloadSettingTable$Columns.TYPE, "0"), o.getString("isSug", "0"), o.getString("isLocalSug", "0"), this.tCm.bPL(), hashMap, this.tCq.tCv);
                } else {
                    BaseSOSWebViewUI.d(this.tCm).a(this.tCm.bTC(), this.tCm.bTE(), this.tCm.bTF(), 1, this.tCq.tCv);
                }
                if (!TextUtils.isEmpty(this.tCm.bTE())) {
                    f.a(this.tCm.scene, this.tCm.fqu, this.tCm.tjs, this.tCm.bTE(), this.tCm.type);
                }
            } catch (RemoteException e) {
            }
        }
    }
}
