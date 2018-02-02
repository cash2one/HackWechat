package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class c$11 implements OnClickListener {
    final /* synthetic */ c nXi;

    c$11(c cVar) {
        this.nXi = cVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", Double.valueOf(c.g(this.nXi)), Double.valueOf(c.h(this.nXi)));
        if (c.g(this.nXi) == -85.0d || c.h(this.nXi) == -1000.0d) {
            x.i("MicroMsg.MMPoiMapUI", "invalid lat lng");
            return;
        }
        this.nXi.nTp.getIController().animateTo(c.g(this.nXi), c.h(this.nXi));
        c.a(this.nXi, c.g(this.nXi));
        c.b(this.nXi, c.h(this.nXi));
        c.k(this.nXi).k(c.i(this.nXi), c.j(this.nXi));
        c.l(this.nXi).setBackgroundResource(R.g.bDv);
        c.l(this.nXi).setEnabled(true);
        c.m(this.nXi);
        c.n(this.nXi);
        c.o(this.nXi).nXf = false;
    }
}
