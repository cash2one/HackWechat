package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v.6;
import android.support.v7.widget.v.b;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

class v$1 implements Runnable {
    final /* synthetic */ ArrayList QZ;
    final /* synthetic */ v Ra;

    v$1(v vVar, ArrayList arrayList) {
        this.Ra = vVar;
        this.QZ = arrayList;
    }

    public final void run() {
        Iterator it = this.QZ.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            e eVar = this.Ra;
            t tVar = bVar.Rr;
            int i = bVar.Rn;
            int i2 = bVar.Ro;
            int i3 = bVar.Rp;
            int i4 = bVar.Rq;
            View view = tVar.VU;
            i = i3 - i;
            i2 = i4 - i2;
            if (i != 0) {
                z.U(view).r(0.0f);
            }
            if (i2 != 0) {
                z.U(view).s(0.0f);
            }
            ai U = z.U(view);
            eVar.QW.add(tVar);
            U.d(eVar.UX).a(new 6(eVar, tVar, i, i2, U)).start();
        }
        this.QZ.clear();
        this.Ra.QT.remove(this.QZ);
    }
}
