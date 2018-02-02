package com.tencent.mm.plugin.appbrand.menu;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.menu.e.1;
import com.tencent.mm.plugin.appbrand.q.j;

class e$1$1 implements Runnable {
    final /* synthetic */ 1 jAA;
    final /* synthetic */ boolean jAz;

    e$1$1(1 1, boolean z) {
        this.jAA = 1;
        this.jAz = z;
    }

    public final void run() {
        Toast.makeText(this.jAA.val$context, this.jAz ? j.iAu : j.iAs, 0).show();
    }
}
