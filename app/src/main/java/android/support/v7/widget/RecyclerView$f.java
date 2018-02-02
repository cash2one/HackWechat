package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.e.b;
import android.support.v7.widget.RecyclerView.t;

class RecyclerView$f implements b {
    final /* synthetic */ RecyclerView UQ;

    private RecyclerView$f(RecyclerView recyclerView) {
        this.UQ = recyclerView;
    }

    public final void l(t tVar) {
        tVar.T(true);
        if (tVar.VZ != null && tVar.Wa == null) {
            tVar.VZ = null;
        }
        tVar.Wa = null;
        if (!t.w(tVar) && !RecyclerView.c(this.UQ, tVar.VU) && tVar.gm()) {
            this.UQ.removeDetachedView(tVar.VU, false);
        }
    }
}
