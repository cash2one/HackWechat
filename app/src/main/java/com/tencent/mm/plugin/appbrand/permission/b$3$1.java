package com.tencent.mm.plugin.appbrand.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.permission.b.3;
import com.tencent.mm.sdk.platformtools.x;

class b$3$1 implements OnClickListener {
    final /* synthetic */ 3 jGv;

    b$3$1(3 3) {
        this.jGv = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(this.jGv.jGs, this.jGv.jGu, 1);
        b.ajv().put(b.a(this.jGv.jGs), b.b(this.jGv.jGs));
        x.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user confirm, appId %s, api %s", b.a(this.jGv.jGs), b.b(this.jGv.jGs));
        b.c(this.jGv.jGs).ajx();
    }
}
