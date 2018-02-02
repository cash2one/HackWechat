package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.tools.g.b;

class CardGiftImageUI$6 implements b {
    final /* synthetic */ CardGiftImageUI kSh;

    CardGiftImageUI$6(CardGiftImageUI cardGiftImageUI) {
        this.kSh = cardGiftImageUI;
    }

    public final void onAnimationStart() {
    }

    public final void onAnimationEnd() {
        new af().post(new 1(this));
    }
}
