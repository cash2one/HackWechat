package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class c$5 implements OnItemClickListener {
    final /* synthetic */ c nXi;

    c$5(c cVar) {
        this.nXi = cVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        f fVar = null;
        if (c.v(this.nXi).nXs < c.v(this.nXi).getCount()) {
            fVar = c.v(this.nXi).rS(i);
        }
        c.b(this.nXi, fVar);
        c.a(this.nXi, fVar);
    }
}
