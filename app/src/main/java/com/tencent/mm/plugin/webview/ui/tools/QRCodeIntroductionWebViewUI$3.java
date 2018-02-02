package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ui.base.h.c;

class QRCodeIntroductionWebViewUI$3 implements c {
    final /* synthetic */ QRCodeIntroductionWebViewUI twZ;

    QRCodeIntroductionWebViewUI$3(QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI) {
        this.twZ = qRCodeIntroductionWebViewUI;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                this.twZ.tlx.bUr();
                return;
            case 1:
                this.twZ.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.twZ.bSL())));
                return;
            default:
                return;
        }
    }
}
