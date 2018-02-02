package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.ui.recents.a.b;

class a$b$1 implements Runnable {
    final /* synthetic */ boolean jPt;
    final /* synthetic */ b jPu;

    a$b$1(b bVar, boolean z) {
        this.jPu = bVar;
        this.jPt = z;
    }

    public final void run() {
        int i = 0;
        if (!(a.b(this.jPu.jPj).isEmpty() || a.b(this.jPu.jPj) == null)) {
            a.b(this.jPu.jPj).bj(a.b(this.jPu.jPj).getItemCount() - 1);
        }
        if (a.m(this.jPu.jPj) != null) {
            int i2;
            b m = a.m(this.jPu.jPj);
            if (this.jPt || a.b(this.jPu.jPj).isEmpty()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            View view = m.jPH;
            if (i2 == 0) {
                i = 4;
            }
            j.s(view, i);
        }
    }
}
