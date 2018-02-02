package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.as.b;

class RecyclerView$4 implements b {
    final /* synthetic */ RecyclerView UQ;

    RecyclerView$4(RecyclerView recyclerView) {
        this.UQ = recyclerView;
    }

    public final void a(t tVar, RecyclerView$e$c recyclerView$e$c, RecyclerView$e$c recyclerView$e$c2) {
        this.UQ.TN.p(tVar);
        RecyclerView.a(this.UQ, tVar, recyclerView$e$c, recyclerView$e$c2);
    }

    public final void b(t tVar, RecyclerView$e$c recyclerView$e$c, RecyclerView$e$c recyclerView$e$c2) {
        RecyclerView.b(this.UQ, tVar, recyclerView$e$c, recyclerView$e$c2);
    }

    public final void c(t tVar, RecyclerView$e$c recyclerView$e$c, RecyclerView$e$c recyclerView$e$c2) {
        tVar.T(false);
        if (RecyclerView.f(this.UQ)) {
            if (this.UQ.Ur.a(tVar, tVar, recyclerView$e$c, recyclerView$e$c2)) {
                RecyclerView.g(this.UQ);
            }
        } else if (this.UQ.Ur.f(tVar, recyclerView$e$c, recyclerView$e$c2)) {
            RecyclerView.g(this.UQ);
        }
    }

    public final void i(t tVar) {
        this.UQ.TV.a(tVar.VU, this.UQ.TN);
    }
}
