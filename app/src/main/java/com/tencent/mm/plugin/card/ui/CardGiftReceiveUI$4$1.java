package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.4;

class CardGiftReceiveUI$4$1 implements Runnable {
    final /* synthetic */ 4 kSX;

    CardGiftReceiveUI$4$1(4 4) {
        this.kSX = 4;
    }

    public final void run() {
        if (CardGiftReceiveUI.f(this.kSX.kSW).getVisibility() != 0) {
            CardGiftReceiveUI.f(this.kSX.kSW).setVisibility(0);
        }
    }
}
