package com.tencent.mm.plugin.appbrand.widget.input;

import java.lang.ref.WeakReference;

class m$1 implements Runnable {
    final /* synthetic */ y jXS;
    final /* synthetic */ int jjZ;

    m$1(int i, y yVar) {
        this.jjZ = i;
        this.jXS = yVar;
    }

    public final void run() {
        m.agr().put(Integer.valueOf(this.jjZ), new WeakReference(this.jXS));
    }
}
