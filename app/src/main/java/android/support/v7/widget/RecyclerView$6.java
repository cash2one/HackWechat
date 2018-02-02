package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.e.a;
import android.support.v7.widget.e.b;
import android.view.View;

class RecyclerView$6 implements a {
    final /* synthetic */ RecyclerView UQ;

    RecyclerView$6(RecyclerView recyclerView) {
        this.UQ = recyclerView;
    }

    public final t aQ(int i) {
        t aY;
        RecyclerView recyclerView = this.UQ;
        int eF = recyclerView.TQ.eF();
        for (int i2 = 0; i2 < eF; i2++) {
            aY = RecyclerView.aY(recyclerView.TQ.aU(i2));
            if (aY != null && !aY.isRemoved() && aY.mPosition == i) {
                break;
            }
        }
        aY = null;
        if (aY == null || this.UQ.TQ.aO(aY.VU)) {
            return null;
        }
        return aY;
    }

    public final void x(int i, int i2) {
        this.UQ.c(i, i2, true);
        this.UQ.UE = true;
        q qVar = this.UQ.UB;
        qVar.VJ += i2;
    }

    public final void y(int i, int i2) {
        this.UQ.c(i, i2, false);
        this.UQ.UE = true;
    }

    public final void a(int i, int i2, Object obj) {
        int i3;
        RecyclerView recyclerView = this.UQ;
        int eF = recyclerView.TQ.eF();
        int i4 = i + i2;
        for (i3 = 0; i3 < eF; i3++) {
            View aU = recyclerView.TQ.aU(i3);
            t aY = RecyclerView.aY(aU);
            if (aY != null && !aY.gb() && aY.mPosition >= i && aY.mPosition < i4) {
                aY.addFlags(2);
                aY.S(obj);
                ((LayoutParams) aU.getLayoutParams()).Vi = true;
            }
        }
        m mVar = recyclerView.TN;
        eF = i + i2;
        for (i3 = mVar.Vp.size() - 1; i3 >= 0; i3--) {
            t tVar = (t) mVar.Vp.get(i3);
            if (tVar != null) {
                i4 = tVar.gd();
                if (i4 >= i && i4 < eF) {
                    tVar.addFlags(2);
                    mVar.bs(i3);
                }
            }
        }
        this.UQ.UF = true;
    }

    public final void d(b bVar) {
        f(bVar);
    }

    private void f(b bVar) {
        switch (bVar.pK) {
            case 1:
                this.UQ.TV.C(bVar.OZ, bVar.Pb);
                return;
            case 2:
                this.UQ.TV.D(bVar.OZ, bVar.Pb);
                return;
            case 4:
                this.UQ.TV.E(bVar.OZ, bVar.Pb);
                return;
            case 8:
                this.UQ.TV.F(bVar.OZ, bVar.Pb);
                return;
            default:
                return;
        }
    }

    public final void e(b bVar) {
        f(bVar);
    }

    public final void z(int i, int i2) {
        int i3;
        RecyclerView recyclerView = this.UQ;
        int eF = recyclerView.TQ.eF();
        for (i3 = 0; i3 < eF; i3++) {
            t aY = RecyclerView.aY(recyclerView.TQ.aU(i3));
            if (!(aY == null || aY.gb() || aY.mPosition < i)) {
                aY.i(i2, false);
                recyclerView.UB.VK = true;
            }
        }
        m mVar = recyclerView.TN;
        int size = mVar.Vp.size();
        for (i3 = 0; i3 < size; i3++) {
            t tVar = (t) mVar.Vp.get(i3);
            if (tVar != null && tVar.mPosition >= i) {
                tVar.i(i2, true);
            }
        }
        recyclerView.requestLayout();
        this.UQ.UE = true;
    }

    public final void A(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = -1;
        RecyclerView recyclerView = this.UQ;
        int eF = recyclerView.TQ.eF();
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (i6 = 0; i6 < eF; i6++) {
            t aY = RecyclerView.aY(recyclerView.TQ.aU(i6));
            if (aY != null && aY.mPosition >= r4 && aY.mPosition <= r3) {
                if (aY.mPosition == i) {
                    aY.i(i2 - i, false);
                } else {
                    aY.i(i3, false);
                }
                recyclerView.UB.VK = true;
            }
        }
        m mVar = recyclerView.TN;
        if (i < i2) {
            i4 = i2;
            i5 = i;
        } else {
            i7 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = mVar.Vp.size();
        for (i6 = 0; i6 < size; i6++) {
            t tVar = (t) mVar.Vp.get(i6);
            if (tVar != null && tVar.mPosition >= r4 && tVar.mPosition <= r3) {
                if (tVar.mPosition == i) {
                    tVar.i(i2 - i, false);
                } else {
                    tVar.i(i7, false);
                }
            }
        }
        recyclerView.requestLayout();
        this.UQ.UE = true;
    }
}
