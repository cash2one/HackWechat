package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v.c;
import android.view.View;

class v$4 extends c {
    final /* synthetic */ v Ra;
    final /* synthetic */ t Rd;
    final /* synthetic */ ai Re;

    v$4(v vVar, t tVar, ai aiVar) {
        this.Ra = vVar;
        this.Rd = tVar;
        this.Re = aiVar;
        super((byte) 0);
    }

    public final void p(View view) {
        this.Ra.z(this.Rd);
    }

    public final void q(View view) {
        this.Re.a(null);
        z.d(view, 1.0f);
        this.Ra.k(this.Rd);
        this.Ra.QX.remove(this.Rd);
        this.Ra.eJ();
    }
}
