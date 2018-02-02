package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class MallProductSubmitUI$4 implements OnClickListener {
    final /* synthetic */ MallProductSubmitUI pgR;

    MallProductSubmitUI$4(MallProductSubmitUI mallProductSubmitUI) {
        this.pgR = mallProductSubmitUI;
    }

    public final void onClick(View view) {
        f d = MallProductSubmitUI.d(this.pgR);
        Intent intent = new Intent();
        intent.putExtra("launch_from_webview", true);
        d.a(d.iQz, "address", ".ui.WalletSelectAddrUI", intent, 1, false);
    }
}
