package com.tencent.mm.ui.appbrand;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements a {
    final /* synthetic */ c xVM;

    c$3(c cVar) {
        this.xVM = cVar;
    }

    public final boolean uF() {
        c cVar = this.xVM;
        x.d("MicroMsg.AppBrandServiceImageBubble", "hide");
        if (cVar.vru != null) {
            cVar.vru.dismiss();
        }
        return false;
    }
}
