package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.x;

class WebViewStubProxyUI$5 implements e {
    final /* synthetic */ WebViewStubProxyUI tvs;

    WebViewStubProxyUI$5(WebViewStubProxyUI webViewStubProxyUI) {
        this.tvs = webViewStubProxyUI;
    }

    public final IBinder asBinder() {
        return null;
    }

    public final boolean Ar(int i) {
        WebViewStubProxyUI.a(this.tvs).Ar(i);
        return false;
    }

    public final boolean n(int i, Bundle bundle) {
        WebViewStubProxyUI.a(this.tvs).n(i, bundle);
        return false;
    }

    public final boolean a(c cVar) {
        WebViewStubProxyUI.a(this.tvs).a(cVar);
        return false;
    }

    public final boolean a(String str, String str2, Bundle bundle, boolean z) {
        x.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
        this.tvs.tvl = WebViewStubProxyUI.OJ(str2);
        final String str3 = str;
        final String str4 = str2;
        final Bundle bundle2 = bundle;
        final boolean z2 = z;
        this.tvs.runOnUiThread(new Runnable(this) {
            final /* synthetic */ WebViewStubProxyUI$5 tvx;

            public final void run() {
                h.Be(WebViewStubProxyUI.b(this.tvx.tvs)).a(null, null, null);
                this.tvx.tvs.finish();
                try {
                    WebViewStubProxyUI.a(this.tvx.tvs).a(str3, str4, bundle2, z2);
                } catch (Exception e) {
                    x.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + e.getMessage());
                }
            }
        });
        return false;
    }

    public final String bRM() {
        return WebViewStubProxyUI.a(this.tvs).bRM();
    }

    public final String aeq() {
        return WebViewStubProxyUI.a(this.tvs).aeq();
    }

    public final String bRN() {
        return WebViewStubProxyUI.a(this.tvs).bRN();
    }

    public final void ko(boolean z) {
        WebViewStubProxyUI.a(this.tvs).ko(z);
    }

    public final void kp(boolean z) {
        WebViewStubProxyUI.a(this.tvs).kp(z);
    }

    public final void p(int i, Bundle bundle) {
        WebViewStubProxyUI.a(this.tvs).p(i, bundle);
    }

    public final void bRO() {
        WebViewStubProxyUI.a(this.tvs).bRO();
    }

    public final void O(Bundle bundle) {
        WebViewStubProxyUI.a(this.tvs).O(bundle);
    }

    public final void OK(String str) {
        WebViewStubProxyUI.a(this.tvs).OK(str);
    }

    public final void bRP() {
        if (WebViewStubProxyUI.a(this.tvs) != null) {
            WebViewStubProxyUI.a(this.tvs).bRP();
        }
    }

    public final void e(String str, String str2, int i, int i2) {
    }

    public final void eM(String str, String str2) {
        WebViewStubProxyUI.a(this.tvs).eM(str, str2);
    }

    public final Bundle e(int i, Bundle bundle) {
        return WebViewStubProxyUI.a(this.tvs).e(i, bundle);
    }

    public final void P(Bundle bundle) {
        WebViewStubProxyUI.a(this.tvs).P(bundle);
    }

    public final void kq(boolean z) {
        WebViewStubProxyUI.a(this.tvs).kq(z);
    }

    public final void eN(String str, String str2) {
        WebViewStubProxyUI.a(this.tvs).eN(str, str2);
    }
}
