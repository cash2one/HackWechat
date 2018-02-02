package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.plugin.scanner.a.h;
import com.tencent.mm.plugin.scanner.ui.h.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;

class h$b$1 implements OnClickListener {
    final /* synthetic */ String lwx;
    final /* synthetic */ a pVK;
    final /* synthetic */ b pVL;

    h$b$1(b bVar, String str, a aVar) {
        this.pVL = bVar;
        this.lwx = str;
        this.pVK = aVar;
    }

    public final void onClick(View view) {
        ar.CG().a(new h(this.lwx, this.pVK.pSx, this.pVK.type, this.lwx, this.pVL.getCount(), this.pVK.showType), 0);
        if (!bh.ov(this.lwx)) {
            Intent intent = new Intent();
            intent.putExtra("key_Product_ID", this.lwx);
            d.b(this.pVL.pVJ.mContext, "scanner", ".ui.ProductUI", intent);
        }
    }
}
