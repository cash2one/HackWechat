package com.tencent.mm.d;

import android.graphics.Rect;
import com.tencent.mm.t.a;
import com.tencent.mm.view.b.a.b;

class c$2 implements b {
    final /* synthetic */ c fiO;

    c$2(c cVar) {
        this.fiO = cVar;
    }

    public final void uY() {
        this.fiO.fiC = true;
        this.fiO.fhY.cdh().cAf().l(new Rect(0, 0, this.fiO.fhY.cdm().getWidth(), this.fiO.fhY.cdm().getHeight()));
        c.a(this.fiO, 200, true, false);
    }

    public final void onStart() {
        c.a(this.fiO, false);
        this.fiO.fiC = false;
        c.a(this.fiO);
        a.gm(282);
    }
}
