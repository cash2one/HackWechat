package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

class v$2 implements Runnable {
    final /* synthetic */ v Ra;
    final /* synthetic */ ArrayList Rb;

    v$2(v vVar, ArrayList arrayList) {
        this.Ra = vVar;
        this.Rb = arrayList;
    }

    public final void run() {
        Iterator it = this.Rb.iterator();
        while (it.hasNext()) {
            v$a android_support_v7_widget_v_a = (v$a) it.next();
            e eVar = this.Ra;
            t tVar = android_support_v7_widget_v_a.Rl;
            View view = tVar == null ? null : tVar.VU;
            t tVar2 = android_support_v7_widget_v_a.Rm;
            View view2 = tVar2 != null ? tVar2.VU : null;
            if (view != null) {
                ai d = z.U(view).d(eVar.UY);
                eVar.QY.add(android_support_v7_widget_v_a.Rl);
                d.r((float) (android_support_v7_widget_v_a.Rp - android_support_v7_widget_v_a.Rn));
                d.s((float) (android_support_v7_widget_v_a.Rq - android_support_v7_widget_v_a.Ro));
                d.q(0.0f).a(new v$7(eVar, android_support_v7_widget_v_a, d)).start();
            }
            if (view2 != null) {
                d = z.U(view2);
                eVar.QY.add(android_support_v7_widget_v_a.Rm);
                d.r(0.0f).s(0.0f).d(eVar.UY).q(1.0f).a(new v$8(eVar, android_support_v7_widget_v_a, d, view2)).start();
            }
        }
        this.Rb.clear();
        this.Ra.QU.remove(this.Rb);
    }
}
