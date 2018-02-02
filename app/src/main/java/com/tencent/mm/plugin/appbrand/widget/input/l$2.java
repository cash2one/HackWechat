package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.widget.input.l.a;
import com.tencent.mm.sdk.platformtools.x;

class l$2 implements Runnable {
    final /* synthetic */ l jXK;

    l$2(l lVar) {
        this.jXK = lVar;
    }

    public final void run() {
        int i = 0;
        x.i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", new Object[]{Integer.valueOf(l.d(this.jXK).size())});
        if (l.d(this.jXK).size() > 0) {
            a[] aVarArr = new a[l.d(this.jXK).size()];
            l.d(this.jXK).toArray(aVarArr);
            int length = aVarArr.length;
            while (i < length) {
                aVarArr[i].agH();
                i++;
            }
        }
    }
}
