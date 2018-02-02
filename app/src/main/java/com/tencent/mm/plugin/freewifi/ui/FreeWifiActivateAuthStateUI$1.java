package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;

class FreeWifiActivateAuthStateUI$1 implements OnClickListener {
    final /* synthetic */ FreeWifiActivateAuthStateUI mGi;

    FreeWifiActivateAuthStateUI$1(FreeWifiActivateAuthStateUI freeWifiActivateAuthStateUI) {
        this.mGi = freeWifiActivateAuthStateUI;
    }

    public final void onClick(View view) {
        String string = this.mGi.getString(R.l.ejM);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.mGi, "webview", ".ui.tools.WebViewUI", intent);
    }
}
