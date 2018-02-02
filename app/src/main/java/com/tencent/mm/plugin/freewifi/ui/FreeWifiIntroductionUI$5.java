package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;

class FreeWifiIntroductionUI$5 implements OnClickListener {
    final /* synthetic */ FreeWifiIntroductionUI mHN;

    FreeWifiIntroductionUI$5(FreeWifiIntroductionUI freeWifiIntroductionUI) {
        this.mHN = freeWifiIntroductionUI;
    }

    public final void onClick(View view) {
        String string = this.mHN.getString(R.l.ejM);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.mHN, "webview", ".ui.tools.WebViewUI", intent);
    }
}
