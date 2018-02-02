package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class c$13 implements OnClickListener {
    final /* synthetic */ c jgI;
    final /* synthetic */ boolean jgS;

    c$13(c cVar, boolean z) {
        this.jgI = cVar;
        this.jgS = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "confirm login");
        dialogInterface.dismiss();
        if (this.jgS) {
            c.a(this.jgI);
            c.b(this.jgI);
            return;
        }
        x.i("MicroMsg.JsApiGetPhoneNumber", "not need to verify sms, and do callback");
        this.jgI.afI();
        g.pQN.h(14249, new Object[]{this.jgI.jgr.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.jgI.jgF), Integer.valueOf(this.jgI.jgG), Integer.valueOf(this.jgI.jgE)});
    }
}
