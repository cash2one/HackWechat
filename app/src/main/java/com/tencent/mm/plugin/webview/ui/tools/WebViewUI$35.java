package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.a;

class WebViewUI$35 implements a {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$35(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void a(ImageView imageView, MenuItem menuItem) {
        if (WebViewUI.i(menuItem)) {
            imageView.setVisibility(8);
            return;
        }
        String str = menuItem.getTitle();
        if (WebViewUI.W(this.tAv).get(str) == null || ((Bitmap) WebViewUI.W(this.tAv).get(str)).isRecycled()) {
            x.w("MicroMsg.WebViewUI", "on attach icon, load from cache fail");
            try {
                String OM = this.tAv.juQ.OM(str);
                if (!bh.ov(OM)) {
                    Bitmap Pd = d.Pd(OM);
                    if (Pd != null && !Pd.isRecycled()) {
                        imageView.setImageBitmap(Pd);
                        WebViewUI.W(this.tAv).put(str, Pd);
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e.getMessage());
                return;
            }
        }
        imageView.setImageBitmap((Bitmap) WebViewUI.W(this.tAv).get(str));
    }
}
