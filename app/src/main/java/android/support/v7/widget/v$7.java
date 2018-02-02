package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.v.c;
import android.view.View;

class v$7 extends c {
    final /* synthetic */ v Ra;
    final /* synthetic */ v$a Rh;
    final /* synthetic */ ai Ri;

    v$7(v vVar, v$a android_support_v7_widget_v_a, ai aiVar) {
        this.Ra = vVar;
        this.Rh = android_support_v7_widget_v_a;
        this.Ri = aiVar;
        super((byte) 0);
    }

    public final void p(View view) {
    }

    public final void q(View view) {
        this.Ri.a(null);
        z.d(view, 1.0f);
        z.b(view, 0.0f);
        z.c(view, 0.0f);
        this.Ra.k(this.Rh.Rl);
        this.Ra.QY.remove(this.Rh.Rl);
        this.Ra.eJ();
    }
}
