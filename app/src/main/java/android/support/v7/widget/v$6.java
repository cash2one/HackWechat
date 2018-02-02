package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v.c;
import android.view.View;

class v$6 extends c {
    final /* synthetic */ v Ra;
    final /* synthetic */ t Rd;
    final /* synthetic */ ai Re;
    final /* synthetic */ int Rf;
    final /* synthetic */ int Rg;

    v$6(v vVar, t tVar, int i, int i2, ai aiVar) {
        this.Ra = vVar;
        this.Rd = tVar;
        this.Rf = i;
        this.Rg = i2;
        this.Re = aiVar;
        super((byte) 0);
    }

    public final void p(View view) {
        this.Ra.A(this.Rd);
    }

    public final void ar(View view) {
        if (this.Rf != 0) {
            z.b(view, 0.0f);
        }
        if (this.Rg != 0) {
            z.c(view, 0.0f);
        }
    }

    public final void q(View view) {
        this.Re.a(null);
        this.Ra.y(this.Rd);
        this.Ra.QW.remove(this.Rd);
        this.Ra.eJ();
    }
}
