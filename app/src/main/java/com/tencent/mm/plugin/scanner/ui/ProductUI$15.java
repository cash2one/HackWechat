package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.scanner.util.n.a;

class ProductUI$15 implements OnClickListener {
    final /* synthetic */ ProductUI pWr;
    final /* synthetic */ a pWs;

    ProductUI$15(ProductUI productUI, a aVar) {
        this.pWr = productUI;
        this.pWs = aVar;
    }

    public final void onClick(View view) {
        ProductUI.a(this.pWr, 10003, this.pWs.field_introlink);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.pWs.field_introlink);
        intent.putExtra("geta8key_scene", ProductUI.k(this.pWr));
        d.b(this.pWr.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
