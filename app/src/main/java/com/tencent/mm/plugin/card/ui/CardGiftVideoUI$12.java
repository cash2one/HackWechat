package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.sdk.platformtools.x;

class CardGiftVideoUI$12 implements Runnable {
    final /* synthetic */ CardGiftVideoUI kTl;

    CardGiftVideoUI$12(CardGiftVideoUI cardGiftVideoUI) {
        this.kTl = cardGiftVideoUI;
    }

    public final void run() {
        x.d("MicroMsg.CardGiftVideoUI", "hide loading.");
        if (!(CardGiftVideoUI.g(this.kTl) == null || CardGiftVideoUI.g(this.kTl).getVisibility() == 8)) {
            CardGiftVideoUI.g(this.kTl).setVisibility(8);
        }
        if (CardGiftVideoUI.h(this.kTl) != null && CardGiftVideoUI.h(this.kTl).getVisibility() != 8) {
            CardGiftVideoUI.h(this.kTl).setVisibility(8);
        }
    }
}
