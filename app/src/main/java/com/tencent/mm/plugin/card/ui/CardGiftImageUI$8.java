package com.tencent.mm.plugin.card.ui;

class CardGiftImageUI$8 implements Runnable {
    final /* synthetic */ String icE;
    final /* synthetic */ CardGiftImageUI kSh;

    CardGiftImageUI$8(CardGiftImageUI cardGiftImageUI, String str) {
        this.kSh = cardGiftImageUI;
        this.icE = str;
    }

    public final void run() {
        if (CardGiftImageUI.f(this.kSh).getVisibility() != 8) {
            CardGiftImageUI.f(this.kSh).setVisibility(8);
        }
        CardGiftImageUI.a(this.kSh, this.icE);
        CardGiftImageUI.g(this.kSh);
        CardGiftImageUI.h(this.kSh).notifyDataSetChanged();
    }
}
