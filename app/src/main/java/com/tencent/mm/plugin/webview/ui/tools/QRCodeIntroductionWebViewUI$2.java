package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class QRCodeIntroductionWebViewUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ QRCodeIntroductionWebViewUI twZ;

    QRCodeIntroductionWebViewUI$2(QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI) {
        this.twZ = qRCodeIntroductionWebViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.twZ.finish();
        return true;
    }
}
