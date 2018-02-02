package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.e;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;
import java.util.Iterator;

class k$7 implements Runnable {
    final /* synthetic */ k jRl;

    k$7(k kVar) {
        this.jRl = kVar;
    }

    public final void run() {
        Iterator it = this.jRl.jRi.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            e eVar = this.jRl;
            ai U = z.U(dVar.VU);
            eVar.jRj.add(dVar);
            U.s(0.0f).d(eVar.UX).a(new k$8(eVar, dVar, U)).start();
        }
        this.jRl.jRi.clear();
    }
}
