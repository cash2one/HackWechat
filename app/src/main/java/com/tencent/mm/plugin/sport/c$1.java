package com.tencent.mm.plugin.sport;

import android.app.Activity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.b.a;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.plugin.sport.b.c;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.plugin.sport.c.n.1;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.q;

class c$1 implements Runnable {
    final /* synthetic */ String gIT;
    final /* synthetic */ Activity oZ;
    final /* synthetic */ c rTB;

    c$1(c cVar, Activity activity, String str) {
        this.rTB = cVar;
        this.oZ = activity;
        this.gIT = str;
    }

    public final void run() {
        Activity activity = this.oZ;
        String str = this.gIT;
        if ((n.rUl == null || !n.rUl.isShowing()) && i.K(5, 1) != 0 && q.FS().equals(str) && !((b) g.h(b.class)).dz(ac.getContext())) {
            n.rUl = u.a(activity, a.gUH, c.dBi, ac.getContext().getString(d.rTA), b.b.rTz, new 1());
        }
    }
}
