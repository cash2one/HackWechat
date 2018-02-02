package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.picker.a;

class h$2 implements Runnable {
    final /* synthetic */ h jpG;
    final /* synthetic */ a jpH;

    h$2(h hVar, a aVar) {
        this.jpG = hVar;
        this.jpH = aVar;
    }

    public final void run() {
        if (this.jpH.kdn != null && (this.jpH.kdn instanceof View)) {
            ((View) this.jpH.kdn).requestLayout();
        }
    }
}
