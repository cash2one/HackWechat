package com.tencent.mm.plugin.card.ui;

import android.view.ViewTreeObserver.OnPreDrawListener;

class CardGiftImageUI$5 implements OnPreDrawListener {
    final /* synthetic */ CardGiftImageUI kSh;

    CardGiftImageUI$5(CardGiftImageUI cardGiftImageUI) {
        this.kSh = cardGiftImageUI;
    }

    public final boolean onPreDraw() {
        CardGiftImageUI.c(this.kSh).getViewTreeObserver().removeOnPreDrawListener(this);
        CardGiftImageUI.e(this.kSh).a(CardGiftImageUI.c(this.kSh), CardGiftImageUI.d(this.kSh), null);
        return true;
    }
}
