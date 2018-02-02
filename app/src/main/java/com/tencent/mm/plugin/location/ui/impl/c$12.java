package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;

class c$12 implements OnClickListener {
    final /* synthetic */ c nXi;

    c$12(c cVar) {
        this.nXi = cVar;
    }

    public final void onClick(View view) {
        c.a(this.nXi, c.ayf(), c.o(this.nXi).nXs, false);
        this.nXi.aWs();
        this.nXi.activity.finish();
    }
}
