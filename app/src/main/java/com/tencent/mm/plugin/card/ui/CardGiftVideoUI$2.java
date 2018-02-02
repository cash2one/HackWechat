package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.sdk.platformtools.x;

class CardGiftVideoUI$2 implements Runnable {
    final /* synthetic */ int hBA = 100;
    final /* synthetic */ int htd;
    final /* synthetic */ CardGiftVideoUI kTl;

    CardGiftVideoUI$2(CardGiftVideoUI cardGiftVideoUI, int i, int i2) {
        this.kTl = cardGiftVideoUI;
        this.htd = i2;
    }

    public final void run() {
        if (CardGiftVideoUI.h(this.kTl) == null) {
            return;
        }
        if (this.hBA == 0) {
            CardGiftVideoUI.h(this.kTl).setVisibility(8);
            return;
        }
        if (CardGiftVideoUI.h(this.kTl).getVisibility() != 0) {
            CardGiftVideoUI.h(this.kTl).setVisibility(0);
        }
        x.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", new Object[]{Integer.valueOf(this.htd), Integer.valueOf(this.hBA)});
        if (CardGiftVideoUI.h(this.kTl).zua != this.hBA && this.hBA > 0) {
            CardGiftVideoUI.h(this.kTl).setMax(this.hBA);
        }
        CardGiftVideoUI.h(this.kTl).setProgress(this.htd);
    }
}
