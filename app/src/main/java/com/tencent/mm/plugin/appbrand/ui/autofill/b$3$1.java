package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.ui.autofill.b.3;
import com.tencent.mm.sdk.platformtools.x;

class b$3$1 implements OnClickListener {
    final /* synthetic */ 3 jOb;

    b$3$1(3 3) {
        this.jOb = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jOb.jNZ.jNX.coZ();
        x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sendSms click");
        if (this.jOb.jNZ.jNt != null) {
            this.jOb.jNZ.jNt.a(this.jOb.jNZ.jNU);
        }
    }
}
