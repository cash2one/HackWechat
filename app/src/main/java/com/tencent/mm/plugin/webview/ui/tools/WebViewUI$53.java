package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.d;

class WebViewUI$53 implements d {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$53(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void cn(int i, int i2) {
        switch (i2) {
            case -1:
                Bundle bundle = new Bundle();
                bundle.putLong("fav_local_id", this.tAv.getIntent().getLongExtra("fav_local_id", -1));
                try {
                    if (this.tAv.juQ.S(bundle)) {
                        x.i("MicroMsg.WebViewUI", "del fav web url ok, finish webview ui");
                        this.tAv.trN.t("mm_del_fav", Boolean.valueOf(true));
                        this.tAv.finish();
                        return;
                    }
                    x.w("MicroMsg.WebViewUI", "try to del web url fail");
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
                    x.e("MicroMsg.WebViewUI", "try to del web url crash");
                    return;
                }
            default:
                x.i("MicroMsg.WebViewUI", "do del cancel");
                return;
        }
    }
}
