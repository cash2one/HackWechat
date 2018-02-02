package com.tencent.mm.plugin.appbrand.widget.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.widget.c.c.a;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements OnCancelListener {
    final /* synthetic */ a jWq;
    final /* synthetic */ c jWs;

    c$3(c cVar, a aVar) {
        this.jWs = cVar;
        this.jWq = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
        this.jWq.d(3, null);
    }
}
