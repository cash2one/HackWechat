package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.scanner.util.n.a;

class ProductUI$16 implements OnClickListener {
    final /* synthetic */ ProductUI pWr;
    final /* synthetic */ a pWs;

    ProductUI$16(ProductUI productUI, a aVar) {
        this.pWr = productUI;
        this.pWs = aVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(this.pWs.field_playurl), "video/*");
        this.pWr.startActivity(intent);
    }
}
