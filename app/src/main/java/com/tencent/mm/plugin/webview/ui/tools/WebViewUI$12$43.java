package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class WebViewUI$12$43 implements Runnable {
    final /* synthetic */ String gID;
    final /* synthetic */ boolean jCE;
    final /* synthetic */ Bitmap tAV;
    final /* synthetic */ int tAW;
    final /* synthetic */ 12 tAx;

    WebViewUI$12$43(12 12, boolean z, Bitmap bitmap, String str, int i) {
        this.tAx = 12;
        this.jCE = z;
        this.tAV = bitmap;
        this.gID = str;
        this.tAW = i;
    }

    public final void run() {
        if (this.jCE) {
            this.tAx.tAv.kw(true);
            return;
        }
        Boolean bool = null;
        String aPk = this.tAx.tAv.aPk();
        if (!bh.ov(aPk)) {
            bool = (Boolean) WebViewUI.s(this.tAx.tAv).get(aPk);
        }
        this.tAx.tAv.kw(Boolean.valueOf(bool == null ? false : bool.booleanValue()).booleanValue());
        if (this.tAV != null && !this.tAV.isRecycled()) {
            this.tAx.tAv.b(this.gID, new BitmapDrawable(this.tAx.tAv.getResources(), this.tAV));
        } else if (!bh.ov(this.gID)) {
            this.tAx.tAv.addTextOptionMenu(0, this.gID, new OnMenuItemClickListener(this) {
                final /* synthetic */ WebViewUI$12$43 tAX;

                {
                    this.tAX = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    x.d("MicroMsg.WebViewUI", "click item: %s", new Object[]{Integer.valueOf(menuItem.getItemId())});
                    d dVar = this.tAX.tAx.tAv.tlx;
                    if (dVar.tGQ) {
                        x.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
                        dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a.a("onNavigationBarRightButtonClick", new HashMap(), dVar.tGS, dVar.tGT) + ")", null);
                    } else {
                        x.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
                    }
                    return false;
                }
            });
        }
        this.tAx.tAv.AJ(this.tAW);
    }
}
