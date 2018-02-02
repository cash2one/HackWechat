package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.tools.g.b;

class CardGiftVideoUI$9 implements b {
    final /* synthetic */ CardGiftVideoUI kTl;

    CardGiftVideoUI$9(CardGiftVideoUI cardGiftVideoUI) {
        this.kTl = cardGiftVideoUI;
    }

    public final void onAnimationStart() {
    }

    public final void onAnimationEnd() {
        new af().post(new 1(this));
    }
}
