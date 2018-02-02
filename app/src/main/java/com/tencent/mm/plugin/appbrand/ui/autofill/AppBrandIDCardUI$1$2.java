package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1;
import com.tencent.mm.sdk.platformtools.bh;

class AppBrandIDCardUI$1$2 implements OnClickListener {
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ 1 jNR;

    AppBrandIDCardUI$1$2(1 1, int i, String str) {
        this.jNR = 1;
        this.fmb = i;
        this.hnj = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("intent_err_code", bh.o(Integer.valueOf(this.fmb), 0));
        intent.putExtra("intent_err_msg", bh.ou(this.hnj));
        this.jNR.jNQ.setResult(1, intent);
        this.jNR.jNQ.finish();
    }
}
