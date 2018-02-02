package com.tencent.mm.plugin.appbrand.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.permission.b.3;
import com.tencent.mm.sdk.platformtools.x;

class b$3$3 implements OnCancelListener {
    final /* synthetic */ 3 jGv;

    b$3$3(3 3) {
        this.jGv = 3;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        b.ajv().E(b.a(this.jGv.jGs), b.b(this.jGv.jGs));
        x.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user cancel, appId %s, api %s", b.a(this.jGv.jGs), b.b(this.jGv.jGs));
        b.c(this.jGv.jGs).onCancel();
    }
}
