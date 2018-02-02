package com.tencent.mm.plugin.appbrand.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;

class d$1 implements OnClickListener {
    final /* synthetic */ d kdt;

    d$1(d dVar) {
        this.kdt = dVar;
    }

    public final void onClick(View view) {
        d.a(this.kdt, true, d.c(this.kdt) == null ? null : d.c(this.kdt).anJ());
    }
}
