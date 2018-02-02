package com.tencent.mm.plugin.card.base;

import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.card.model.am;

class CardBaseUI$7 implements a$a {
    final /* synthetic */ CardBaseUI kIn;

    CardBaseUI$7(CardBaseUI cardBaseUI) {
        this.kIn = cardBaseUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (z) {
            if (!(f2 == -85.0f || f == -1000.0f)) {
                CardBaseUI.a(this.kIn, f2);
                CardBaseUI.b(this.kIn, f);
                am.auG().u(CardBaseUI.a(this.kIn), CardBaseUI.b(this.kIn));
                this.kIn.atb();
            }
            if (!CardBaseUI.c(this.kIn)) {
                CardBaseUI.d(this.kIn);
                o.a(2010, f, f2, (int) d2);
            }
            return false;
        }
        this.kIn.atc();
        return true;
    }
}
