package com.tencent.mm.plugin.card.ui;

class CardGiftImageUI$7 implements Runnable {
    final /* synthetic */ CardGiftImageUI kSh;

    CardGiftImageUI$7(CardGiftImageUI cardGiftImageUI) {
        this.kSh = cardGiftImageUI;
    }

    public final void run() {
        if (CardGiftImageUI.f(this.kSh).getVisibility() != 0) {
            CardGiftImageUI.f(this.kSh).setVisibility(0);
        }
    }
}
