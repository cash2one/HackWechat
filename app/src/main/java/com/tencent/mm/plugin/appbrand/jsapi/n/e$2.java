package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements OnCancelListener {
    final /* synthetic */ e jvd;

    e$2(e eVar) {
        this.jvd = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.jvd.juW != null && e.h(this.jvd) != null) {
            try {
                e.h(this.jvd).OV(this.jvd.juW.tvd);
                this.jvd.juW.bRG();
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cancel capture failed");
            }
        }
    }
}
