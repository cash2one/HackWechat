package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.ui.recents.a.d;
import com.tencent.mm.ui.widget.i;

class a$d$1 extends i {
    final /* synthetic */ d jPE;

    a$d$1(d dVar, Context context) {
        this.jPE = dVar;
        super(context);
    }

    public final boolean bQ(int i, int i2) {
        if (this.jPE.VU.getParent() != null) {
            this.jPE.VU.getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.bQ(i, i2);
    }

    public final void onDismiss() {
        if (this.jPE.VU.getParent() != null) {
            this.jPE.VU.getParent().requestDisallowInterceptTouchEvent(false);
        }
        super.onDismiss();
    }
}
