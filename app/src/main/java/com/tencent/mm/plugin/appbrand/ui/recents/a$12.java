package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class a$12 implements a {
    final /* synthetic */ a jPj;

    a$12(a aVar) {
        this.jPj = aVar;
    }

    public final void a(String str, l lVar) {
        if (!"single".equals(str)) {
            return;
        }
        if (3 == lVar.iYZ || 2 == lVar.iYZ) {
            this.jPj.runOnUiThread(new 1(this));
            a.a(this.jPj, true, Long.MAX_VALUE, false);
        }
    }
}
