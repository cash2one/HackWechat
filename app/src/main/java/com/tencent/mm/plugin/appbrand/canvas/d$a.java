package com.tencent.mm.plugin.appbrand.canvas;

import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import java.lang.ref.WeakReference;

class d$a implements c {
    private WeakReference<a> iKM;

    d$a(a aVar) {
        this.iKM = new WeakReference(aVar);
    }

    public final void invalidate() {
        a aVar = (a) this.iKM.get();
        if (aVar != null) {
            aVar.abh();
        }
    }
}
