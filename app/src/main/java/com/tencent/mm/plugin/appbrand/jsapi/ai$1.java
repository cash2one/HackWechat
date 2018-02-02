package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.ui.MMActivity.a;

class ai$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ ai jds;

    ai$1(ai aiVar, j jVar, int i) {
        this.jds = aiVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.jds.hashCode() & 65535)) {
            this.iZy.E(this.gOK, this.jds.e("ok", null));
        }
    }
}
