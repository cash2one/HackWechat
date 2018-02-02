package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.ui.MMActivity.a;

class a$2 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ a jiG;

    a$2(a aVar, j jVar, int i) {
        this.jiG = aVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        this.iZy.E(this.gOK, this.jiG.e("ok", null));
    }
}
