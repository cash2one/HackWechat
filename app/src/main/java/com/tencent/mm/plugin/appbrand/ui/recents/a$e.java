package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.k;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;

final class a$e extends k implements Runnable {
    final /* synthetic */ a jPj;

    private a$e(a aVar) {
        this.jPj = aVar;
    }

    public final void e(RecyclerView recyclerView, int i) {
        a.a(this.jPj, i == 2);
        if (i == 0) {
            this.jPj.s(this);
        }
    }

    public final void run() {
        if (a.g(this.jPj) != null && a.n(this.jPj) != null && a.b(this.jPj) != null && a.x(this.jPj) != null) {
            int eZ = a.n(this.jPj).eZ();
            int fa = a.n(this.jPj).fa();
            for (int i = eZ; i <= fa; i++) {
                RecyclerView$t bi = a.g(this.jPj).bi(i);
                if (bi instanceof d) {
                    i alt = ((d) bi).alt();
                    if (alt != null) {
                        a.x(this.jPj).b((d) bi, alt.iJJ);
                    }
                }
            }
        }
    }
}
