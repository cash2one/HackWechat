package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;

class c$11 implements OnClickListener {
    final /* synthetic */ a tXK;
    final /* synthetic */ c tXL;

    c$11(c cVar, a aVar) {
        this.tXL = cVar;
        this.tXK = aVar;
    }

    public final void onClick(View view) {
        boolean z;
        boolean z2 = true;
        g.pQN.h(14547, Integer.valueOf(7));
        t tVar = u.tWi;
        if (this.tXL.tXG) {
            z = false;
        } else {
            z = true;
        }
        c.c(tVar, Boolean.valueOf(z));
        c cVar = this.tXL;
        if (this.tXL.tXG) {
            z2 = false;
        }
        cVar.tXG = z2;
        c.a(this.tXL, view, this.tXL.tXG);
        c.b(this.tXK);
    }
}
