package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;

class FreeWifiIntroductionUI$4 implements OnClickListener {
    final /* synthetic */ FreeWifiIntroductionUI mHN;

    FreeWifiIntroductionUI$4(FreeWifiIntroductionUI freeWifiIntroductionUI) {
        this.mHN = freeWifiIntroductionUI;
    }

    public final void onClick(View view) {
        String string;
        if (FreeWifiIntroductionUI.b(this.mHN) == 3) {
            string = this.mHN.getString(R.l.evf);
        } else {
            string = this.mHN.getString(R.l.ejZ);
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.mHN, "webview", ".ui.tools.WebViewUI", intent);
    }
}
