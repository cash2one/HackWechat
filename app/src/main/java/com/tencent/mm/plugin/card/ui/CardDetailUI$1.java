package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.plugin.card.a.i;
import com.tencent.mm.plugin.card.model.am;

class CardDetailUI$1 implements a$a {
    final /* synthetic */ CardDetailUI kQK;

    CardDetailUI$1(CardDetailUI cardDetailUI) {
        this.kQK = cardDetailUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        if (CardDetailUI.a(this.kQK) == -85.0f && CardDetailUI.b(this.kQK) == -1000.0f) {
            CardDetailUI.a(this.kQK, f2);
            CardDetailUI.b(this.kQK, f);
            am.auG().u(CardDetailUI.a(this.kQK), CardDetailUI.b(this.kQK));
        }
        i c = CardDetailUI.c(this.kQK);
        float b = CardDetailUI.b(this.kQK);
        float a = CardDetailUI.a(this.kQK);
        synchronized (c.kIX) {
            c.gyz = a;
            c.gyA = b;
        }
        if (CardDetailUI.d(this.kQK)) {
            CardDetailUI.e(this.kQK);
            CardDetailUI.f(this.kQK);
        }
        CardDetailUI.g(this.kQK);
        return false;
    }
}
