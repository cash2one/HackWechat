package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v.5;
import java.util.ArrayList;
import java.util.Iterator;

class v$3 implements Runnable {
    final /* synthetic */ v Ra;
    final /* synthetic */ ArrayList Rc;

    v$3(v vVar, ArrayList arrayList) {
        this.Ra = vVar;
        this.Rc = arrayList;
    }

    public final void run() {
        Iterator it = this.Rc.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            RecyclerView$e recyclerView$e = this.Ra;
            ai U = z.U(tVar.VU);
            recyclerView$e.QV.add(tVar);
            U.q(1.0f).d(recyclerView$e.UV).a(new 5(recyclerView$e, tVar, U)).start();
        }
        this.Rc.clear();
        this.Ra.QS.remove(this.Rc);
    }
}
