package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;

class c$16 implements OnClickListener {
    final /* synthetic */ c nXi;

    c$16(c cVar) {
        this.nXi = cVar;
    }

    public final void onClick(View view) {
        if (!c.q(this.nXi)) {
            c.u(this.nXi);
        }
        c.v(this.nXi).clean();
        c.w(this.nXi).setAdapter(c.v(this.nXi));
        c.v(this.nXi).notifyDataSetChanged();
        c.x(this.nXi).setVisibility(8);
    }
}
