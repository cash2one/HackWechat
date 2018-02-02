package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.ui.o$a;

class CardNewMsgUI$5 implements o$a {
    final /* synthetic */ CardNewMsgUI kUG;

    CardNewMsgUI$5(CardNewMsgUI cardNewMsgUI) {
        this.kUG = cardNewMsgUI;
    }

    public final void Xw() {
    }

    public final void Xv() {
        CardNewMsgUI.g(this.kUG);
        if (CardNewMsgUI.a(this.kUG).awe() && am.auC().Tq() == 0) {
            CardNewMsgUI.c(this.kUG).setVisibility(8);
        }
    }
}
