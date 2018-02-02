package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class RemittanceHKUI$1 implements OnClickListener {
    final /* synthetic */ RemittanceHKUI pPa;

    RemittanceHKUI$1(RemittanceHKUI remittanceHKUI) {
        this.pPa = remittanceHKUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.RemittanceHKUI", "hy: on click banner");
        if (!bh.ov(RemittanceHKUI.a(this.pPa))) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", RemittanceHKUI.a(this.pPa));
            intent.putExtra("showShare", false);
            d.b(this.pPa.mController.xIM, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }
}
