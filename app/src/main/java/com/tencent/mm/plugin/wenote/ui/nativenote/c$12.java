package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;

class c$12 implements OnClickListener {
    final /* synthetic */ a tXK;
    final /* synthetic */ c tXL;

    c$12(c cVar, a aVar) {
        this.tXL = cVar;
        this.tXK = aVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        g.pQN.h(14547, Integer.valueOf(8));
        this.tXL.tXD.setPressed(false);
        this.tXL.tXB.setPressed(false);
        if (this.tXL.tXI || this.tXL.tXJ) {
            this.tXL.tXH = false;
        }
        c.c(u.tWk, Boolean.valueOf(!this.tXL.tXH));
        c cVar = this.tXL;
        if (this.tXL.tXH) {
            z = false;
        }
        cVar.tXH = z;
        c.a(this.tXL, view, this.tXL.tXH);
        c.b(this.tXK);
        this.tXL.tXI = false;
        this.tXL.tXJ = false;
    }
}
