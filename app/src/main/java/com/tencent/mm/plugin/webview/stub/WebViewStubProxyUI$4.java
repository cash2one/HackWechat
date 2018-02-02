package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.base.model.d.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

class WebViewStubProxyUI$4 implements a {
    final /* synthetic */ r kDb;
    final /* synthetic */ WebViewStubProxyUI tvs;

    WebViewStubProxyUI$4(WebViewStubProxyUI webViewStubProxyUI, r rVar) {
        this.tvs = webViewStubProxyUI;
        this.kDb = rVar;
    }

    public final void dO(boolean z) {
        if (this.kDb != null) {
            this.kDb.dismiss();
        }
        Bundle bundle;
        if (z) {
            if (WebViewStubProxyUI.a(this.tvs) != null) {
                bundle = new Bundle();
                bundle.putBoolean("add_shortcut_status", true);
                try {
                    WebViewStubProxyUI.a(this.tvs).e(54, bundle);
                } catch (Exception e) {
                    x.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e.getMessage());
                }
            }
            h.a(this.tvs, R.l.eXS, R.l.dGO, false, new 1(this));
            return;
        }
        Toast.makeText(this.tvs.mController.xIM, this.tvs.mController.xIM.getString(R.l.eXR), 0).show();
        if (WebViewStubProxyUI.a(this.tvs) != null) {
            bundle = new Bundle();
            bundle.putBoolean("add_shortcut_status", false);
            try {
                WebViewStubProxyUI.a(this.tvs).e(54, bundle);
            } catch (Exception e2) {
                x.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e2.getMessage());
            }
        }
        this.tvs.finish();
    }
}
