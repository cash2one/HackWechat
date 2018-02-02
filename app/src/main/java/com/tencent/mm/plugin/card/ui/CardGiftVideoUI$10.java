package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.sdk.platformtools.ak.a;

class CardGiftVideoUI$10 implements a {
    final /* synthetic */ CardGiftVideoUI kTl;

    CardGiftVideoUI$10(CardGiftVideoUI cardGiftVideoUI) {
        this.kTl = cardGiftVideoUI;
    }

    public final boolean uF() {
        if (CardGiftVideoUI.e(this.kTl).isPlaying()) {
            CardGiftVideoUI cardGiftVideoUI = this.kTl;
            int currentPosition = CardGiftVideoUI.e(this.kTl).getCurrentPosition() / 1000;
            if (cardGiftVideoUI.kTh != null && cardGiftVideoUI.duration > 0) {
                currentPosition = cardGiftVideoUI.duration - currentPosition;
                if (currentPosition < 0) {
                    currentPosition = 0;
                }
                cardGiftVideoUI.kTh.setText(currentPosition + "\"");
            }
        }
        return true;
    }
}
