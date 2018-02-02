package com.tencent.mm.plugin.appbrand.widget;

import android.view.View;
import android.view.View.OnClickListener;

class c$2 implements OnClickListener {
    final /* synthetic */ c jUG;

    public c$2(c cVar) {
        this.jUG = cVar;
    }

    public final void onClick(View view) {
        this.jUG.lR(c.b(this.jUG).indexOfChild(view));
        c.c(this.jUG);
    }
}
