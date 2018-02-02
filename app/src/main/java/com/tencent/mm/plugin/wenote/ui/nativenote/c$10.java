package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;

class c$10 implements OnClickListener {
    final /* synthetic */ a tXK;
    final /* synthetic */ c tXL;

    c$10(c cVar, a aVar) {
        this.tXL = cVar;
        this.tXK = aVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        g.pQN.h(14547, new Object[]{Integer.valueOf(11)});
        this.tXL.tXA.setPressed(false);
        this.tXL.tXB.setPressed(false);
        if (this.tXL.tXI || this.tXL.tXH) {
            this.tXL.tXJ = false;
        }
        c.c(u.tWj, Boolean.valueOf(!this.tXL.tXJ));
        c cVar = this.tXL;
        if (this.tXL.tXJ) {
            z = false;
        }
        cVar.tXJ = z;
        c.a(this.tXL, view, this.tXL.tXJ);
        c.b(this.tXK);
        this.tXL.tXI = false;
        this.tXL.tXH = false;
    }
}
