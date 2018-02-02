package android.support.v7.widget;

import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.c;

class RecyclerView$o extends c {
    final /* synthetic */ RecyclerView UQ;

    private RecyclerView$o(RecyclerView recyclerView) {
        this.UQ = recyclerView;
    }

    public final void onChanged() {
        this.UQ.w(null);
        boolean z = RecyclerView.h(this.UQ).US;
        this.UQ.UB.VK = true;
        RecyclerView.n(this.UQ);
        if (!this.UQ.TP.et()) {
            this.UQ.requestLayout();
        }
    }

    public final void c(int i, int i2, Object obj) {
        Object obj2 = 1;
        this.UQ.w(null);
        e eVar = this.UQ.TP;
        eVar.OS.add(eVar.a(4, i, i2, obj));
        eVar.OY |= 4;
        if (eVar.OS.size() != 1) {
            obj2 = null;
        }
        if (obj2 != null) {
            fX();
        }
    }

    public final void Z(int i, int i2) {
        int i3 = 1;
        this.UQ.w(null);
        e eVar = this.UQ.TP;
        eVar.OS.add(eVar.a(1, i, i2, null));
        eVar.OY |= 1;
        if (eVar.OS.size() != 1) {
            i3 = 0;
        }
        if (i3 != 0) {
            fX();
        }
    }

    public final void aa(int i, int i2) {
        Object obj = 1;
        this.UQ.w(null);
        e eVar = this.UQ.TP;
        eVar.OS.add(eVar.a(2, i, i2, null));
        eVar.OY |= 2;
        if (eVar.OS.size() != 1) {
            obj = null;
        }
        if (obj != null) {
            fX();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ab(int i, int i2) {
        Object obj = 1;
        this.UQ.w(null);
        e eVar = this.UQ.TP;
        if (i != i2) {
            eVar.OS.add(eVar.a(8, i, i2, null));
            eVar.OY |= 8;
        }
        obj = null;
        if (obj != null) {
            fX();
        }
    }

    private void fX() {
        if (RecyclerView.o(this.UQ) && RecyclerView.p(this.UQ) && RecyclerView.q(this.UQ)) {
            z.a(this.UQ, RecyclerView.r(this.UQ));
            return;
        }
        RecyclerView.s(this.UQ);
        this.UQ.requestLayout();
    }
}
