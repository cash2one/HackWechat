package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.storage.x;

class b$2 implements a {
    final /* synthetic */ x rAD;
    final /* synthetic */ b vnd;

    b$2(b bVar, x xVar) {
        this.vnd = bVar;
        this.rAD = xVar;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            this.vnd.N(this.rAD);
        } else {
            this.vnd.fW(0);
        }
        this.vnd.vna.dismiss();
    }
}
