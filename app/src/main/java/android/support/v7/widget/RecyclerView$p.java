package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.h;
import android.view.View;

public abstract class RecyclerView$p {
    h TG;
    RecyclerView Va;
    public int Vv = -1;
    boolean Vw;
    boolean Vx;
    View Vy;
    private final a Vz = new a();

    protected abstract void a(int i, int i2, a aVar);

    protected abstract void a(View view, a aVar);

    protected abstract void onStop();

    static /* synthetic */ void a(RecyclerView$p recyclerView$p, int i, int i2) {
        boolean z = false;
        RecyclerView recyclerView = recyclerView$p.Va;
        if (!recyclerView$p.Vx || recyclerView$p.Vv == -1 || recyclerView == null) {
            recyclerView$p.stop();
        }
        recyclerView$p.Vw = false;
        if (recyclerView$p.Vy != null) {
            if (RecyclerView.ba(recyclerView$p.Vy) == recyclerView$p.Vv) {
                View view = recyclerView$p.Vy;
                RecyclerView$q recyclerView$q = recyclerView.UB;
                recyclerView$p.a(view, recyclerView$p.Vz);
                a.a(recyclerView$p.Vz, recyclerView);
                recyclerView$p.stop();
            } else {
                recyclerView$p.Vy = null;
            }
        }
        if (recyclerView$p.Vx) {
            RecyclerView$q recyclerView$q2 = recyclerView.UB;
            recyclerView$p.a(i, i2, recyclerView$p.Vz);
            if (recyclerView$p.Vz.VC >= 0) {
                z = true;
            }
            a.a(recyclerView$p.Vz, recyclerView);
            if (!z) {
                return;
            }
            if (recyclerView$p.Vx) {
                recyclerView$p.Vw = true;
                RecyclerView.x(recyclerView).fZ();
                return;
            }
            recyclerView$p.stop();
        }
    }

    protected final void stop() {
        if (this.Vx) {
            onStop();
            this.Va.UB.Vv = -1;
            this.Vy = null;
            this.Vv = -1;
            this.Vw = false;
            this.Vx = false;
            h.a(this.TG, this);
            this.TG = null;
            this.Va = null;
        }
    }
}
