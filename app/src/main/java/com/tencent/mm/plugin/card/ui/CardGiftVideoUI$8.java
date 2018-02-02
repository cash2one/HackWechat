package com.tencent.mm.plugin.card.ui;

import android.view.ViewTreeObserver.OnPreDrawListener;

class CardGiftVideoUI$8 implements OnPreDrawListener {
    final /* synthetic */ CardGiftVideoUI kTl;

    CardGiftVideoUI$8(CardGiftVideoUI cardGiftVideoUI) {
        this.kTl = cardGiftVideoUI;
    }

    public final boolean onPreDraw() {
        CardGiftVideoUI.b(this.kTl).getViewTreeObserver().removeOnPreDrawListener(this);
        CardGiftVideoUI.d(this.kTl).a(CardGiftVideoUI.b(this.kTl), CardGiftVideoUI.c(this.kTl), null);
        return true;
    }
}
