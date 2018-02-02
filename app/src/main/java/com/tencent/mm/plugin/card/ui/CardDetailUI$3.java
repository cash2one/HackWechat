package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.x;

class CardDetailUI$3 implements e$d {
    final /* synthetic */ CardDetailUI kQK;

    CardDetailUI$3(CardDetailUI cardDetailUI) {
        this.kQK = cardDetailUI;
    }

    public final void avC() {
        CardDetailUI.i(this.kQK);
    }

    public final void wA(String str) {
        CardDetailUI.a(this.kQK, str);
    }

    public final void avD() {
        CardDetailUI.j(this.kQK);
    }

    public final void avE() {
        CardDetailUI.k(this.kQK);
    }

    public final void avF() {
        CardDetailUI.h(this.kQK);
    }

    public final void avG() {
        CardDetailUI.l(this.kQK);
    }

    public final void d(b bVar) {
        CardDetailUI.a(this.kQK, bVar);
        CardDetailUI.b(this.kQK, bVar.atF());
        CardDetailUI.m(this.kQK).kIw = CardDetailUI.n(this.kQK);
    }

    public final void avB() {
        CardDetailUI.o(this.kQK);
    }

    public final void avH() {
        x.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
    }

    public final void ed(boolean z) {
        x.i("MicroMsg.CardDetailUI", "doMark()");
        CardDetailUI.p(this.kQK);
        CardDetailUI.q(this.kQK);
        CardDetailUI.a(this.kQK, z);
        if (CardDetailUI.r(this.kQK).atu()) {
            am.auM().A(CardDetailUI.n(this.kQK), l.wV(CardDetailUI.r(this.kQK).atH()), 2);
        } else {
            am.auM().A(CardDetailUI.n(this.kQK), l.wV(CardDetailUI.r(this.kQK).atH()), 1);
        }
    }
}
