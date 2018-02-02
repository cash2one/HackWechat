package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.scanner.a.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class ProductUI$8 implements OnCancelListener {
    final /* synthetic */ ProductUI pWr;
    final /* synthetic */ d pWu;

    ProductUI$8(ProductUI productUI, d dVar) {
        this.pWr = productUI;
        this.pWu = dVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.d("MicroMsg.scanner.ProductUI", "User cancel");
        ar.CG().c(this.pWu);
    }
}
