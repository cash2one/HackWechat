package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.text.TextUtils;
import com.tencent.mm.plugin.aj.a.f;

class FTSBaseWebViewUI$8 implements Runnable {
    final /* synthetic */ FTSBaseWebViewUI tCF;

    FTSBaseWebViewUI$8(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.tCF = fTSBaseWebViewUI;
    }

    public final void run() {
        if (FTSBaseWebViewUI.e(this.tCF) != null) {
            FTSBaseWebViewUI.f(this.tCF).a(this.tCF.bTC(), this.tCF.bTE(), this.tCF.bTF(), 0, null);
            if (!TextUtils.isEmpty(this.tCF.bTE())) {
                f.a(FTSBaseWebViewUI.g(this.tCF), this.tCF.fqu, this.tCF.tjs, this.tCF.bTE(), FTSBaseWebViewUI.h(this.tCF));
            }
        }
    }
}
