package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.2;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h$d;

class ProductFurtherInfoUI$2$1 implements h$d {
    final /* synthetic */ 2 pVC;

    ProductFurtherInfoUI$2$1(2 2) {
        this.pVC = 2;
    }

    public final void cn(int i, int i2) {
        switch (i2) {
            case 0:
                if (!bh.ov(ProductFurtherInfoUI.a(this.pVC.pVB))) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", ProductFurtherInfoUI.a(this.pVC.pVB));
                    d.b(this.pVC.pVB.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
