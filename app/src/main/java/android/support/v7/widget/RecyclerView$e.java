package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerView$e {
    b UT = null;
    private ArrayList<a> UU = new ArrayList();
    public long UV = 120;
    public long UW = 120;
    public long UX = 250;
    public long UY = 250;

    interface b {
        void l(t tVar);
    }

    public abstract boolean a(t tVar, t tVar2, c cVar, c cVar2);

    public abstract void d(t tVar);

    public abstract boolean d(t tVar, c cVar, c cVar2);

    public abstract boolean e(t tVar, c cVar, c cVar2);

    public abstract void eI();

    public abstract void eK();

    public abstract boolean f(t tVar, c cVar, c cVar2);

    public abstract boolean isRunning();

    public c a(q qVar, t tVar, int i, List<Object> list) {
        return new c().b(tVar, 0);
    }

    static int j(t tVar) {
        int x = t.x(tVar) & 14;
        if (tVar.gk()) {
            return 4;
        }
        if ((x & 4) != 0) {
            return x;
        }
        int i = tVar.VV;
        int ge = tVar.ge();
        if (i == -1 || ge == -1 || i == ge) {
            return x;
        }
        return x | 2048;
    }

    public final void k(t tVar) {
        l(tVar);
        if (this.UT != null) {
            this.UT.l(tVar);
        }
    }

    public void l(t tVar) {
    }

    public final boolean a(a aVar) {
        boolean isRunning = isRunning();
        if (aVar != null) {
            if (isRunning) {
                this.UU.add(aVar);
            } else {
                aVar.fS();
            }
        }
        return isRunning;
    }

    public boolean m(t tVar) {
        return true;
    }

    public boolean a(t tVar, List<Object> list) {
        return m(tVar);
    }

    public final void fR() {
        int size = this.UU.size();
        for (int i = 0; i < size; i++) {
            ((a) this.UU.get(i)).fS();
        }
        this.UU.clear();
    }
}
