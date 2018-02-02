package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class l$1 implements Runnable {
    final /* synthetic */ l jXK;

    l$1(l lVar) {
        this.jXK = lVar;
    }

    public final void run() {
        int i = 0;
        x.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInativePanelView, mPanel %s", new Object[]{l.b(this.jXK).getClass().getSimpleName()});
        if (l.b(this.jXK) != null) {
            while (i < this.jXK.getChildCount()) {
                View childAt = this.jXK.getChildAt(i);
                if (!(childAt == null || childAt == l.c(this.jXK) || childAt == l.b(this.jXK))) {
                    l.bU(childAt);
                }
                i++;
            }
        }
    }
}
