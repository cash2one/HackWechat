package com.tencent.mm.ui.appbrand;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class a$2 implements c {
    final /* synthetic */ a xVC;

    a$2(a aVar) {
        this.xVC = aVar;
    }

    public final void a(n nVar) {
        if (this.xVC.xVA == null) {
            x.e("MicroMsg.AppBrandSerivceActionSheet", "resetOnCreateMenuListener, state is null");
        } else {
            this.xVC.xVA.a(nVar);
        }
    }
}
