package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.q.c;

class h$1 implements e {
    final /* synthetic */ h jXi;
    final /* synthetic */ int jjZ;

    public h$1(h hVar, int i) {
        this.jXi = hVar;
        this.jjZ = i;
    }

    public final void onDestroy() {
        c.runOnUiThread(new 1(this));
    }
}
