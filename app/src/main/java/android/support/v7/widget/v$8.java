package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.v.c;
import android.view.View;

class v$8 extends c {
    final /* synthetic */ v Ra;
    final /* synthetic */ v$a Rh;
    final /* synthetic */ ai Rj;
    final /* synthetic */ View Rk;

    v$8(v vVar, v$a android_support_v7_widget_v_a, ai aiVar, View view) {
        this.Ra = vVar;
        this.Rh = android_support_v7_widget_v_a;
        this.Rj = aiVar;
        this.Rk = view;
        super((byte) 0);
    }

    public final void p(View view) {
    }

    public final void q(View view) {
        this.Rj.a(null);
        z.d(this.Rk, 1.0f);
        z.b(this.Rk, 0.0f);
        z.c(this.Rk, 0.0f);
        this.Ra.k(this.Rh.Rm);
        this.Ra.QY.remove(this.Rh.Rm);
        this.Ra.eJ();
    }
}
