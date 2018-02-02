package com.tencent.mm.d;

import android.graphics.Rect;
import com.tencent.mm.cache.a;
import com.tencent.mm.view.b.a$b;

class c$1 implements a$b {
    final /* synthetic */ c fiO;

    c$1(c cVar) {
        this.fiO = cVar;
    }

    public final void uY() {
        if (((a) this.fiO.uI()).gBw.isIdentity()) {
            a aVar = (a) this.fiO.uI();
            aVar.gBw.set(this.fiO.uR());
        }
        Rect rect = new Rect();
        if (this.fiO.fhY.cdm() == null) {
            rect.set(0, 0, this.fiO.fhY.cdh().cAf().zEC.width(), this.fiO.fhY.cdh().cAf().zEC.height());
        } else {
            rect.set(0, 0, this.fiO.fhY.cdm().getWidth(), this.fiO.fhY.cdm().getHeight());
        }
        this.fiO.fhY.cdh().cAf().l(rect);
        c.a(this.fiO, 200, true, false);
        this.fiO.uT();
    }

    public final void onStart() {
        c.a(this.fiO, false);
        this.fiO.fiC = false;
    }
}
