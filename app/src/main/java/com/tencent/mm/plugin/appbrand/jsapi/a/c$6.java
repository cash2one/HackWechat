package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class c$6 implements OnClickListener {
    final /* synthetic */ c jgI;

    c$6(c cVar) {
        this.jgI = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        x.e("MicroMsg.JsApiGetPhoneNumber", "verify code is error, do send the right code");
        c.a(this.jgI);
    }
}
