package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class QRCodeIntroductionWebViewUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ QRCodeIntroductionWebViewUI twZ;

    QRCodeIntroductionWebViewUI$1(QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI) {
        this.twZ = qRCodeIntroductionWebViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        QRCodeIntroductionWebViewUI.a(this.twZ);
        return true;
    }
}
