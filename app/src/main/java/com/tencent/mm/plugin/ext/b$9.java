package com.tencent.mm.plugin.ext;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class b$9 implements a {
    final /* synthetic */ b lZF;

    b$9(b bVar) {
        this.lZF = bVar;
    }

    public final void a(String str, l lVar) {
        if (!b.b(this.lZF).contains(str)) {
            b.b(this.lZF).add(str);
        }
        b.c(this.lZF).removeMessages(0);
        b.c(this.lZF).sendEmptyMessageDelayed(0, 60);
    }
}
