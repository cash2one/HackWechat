package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class c$7 implements OnClickListener {
    final /* synthetic */ c jgI;

    c$7(c cVar) {
        this.jgI = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.jgI.jgr.E(this.jgI.jcN, this.jgI.e("fail", null));
    }
}
