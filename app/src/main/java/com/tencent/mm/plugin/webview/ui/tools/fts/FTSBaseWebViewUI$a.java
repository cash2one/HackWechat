package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.ui.fts.widget.a.b;

public class FTSBaseWebViewUI$a implements b {
    final /* synthetic */ FTSBaseWebViewUI tCF;
    String tCr;
    int tCs;
    String userName;

    public FTSBaseWebViewUI$a(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.tCF = fTSBaseWebViewUI;
    }

    public final String getTagName() {
        return this.tCr;
    }

    public final int compareTo(Object obj) {
        if (obj == null || !(obj instanceof FTSBaseWebViewUI$a)) {
            return -1;
        }
        return this.tCr.compareTo(((FTSBaseWebViewUI$a) obj).tCr);
    }
}
