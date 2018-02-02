package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

class c$2 implements OnClickListener {
    final /* synthetic */ a tXK;
    final /* synthetic */ c tXL;

    c$2(c cVar, a aVar) {
        this.tXL = cVar;
        this.tXK = aVar;
    }

    public final void onClick(View view) {
        g.pQN.h(14547, new Object[]{Integer.valueOf(10)});
        b gVar = new com.tencent.mm.plugin.wenote.model.a.g();
        k bWZ = k.bWZ();
        if (bWZ != null) {
            c.bWp().a(gVar, bWZ.bXc(), false, false, true);
        } else {
            c.bWp().a(gVar, null, false, false, true);
        }
        c.b(this.tXK);
    }
}
