package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.R;
import com.tencent.mm.ui.contact.LabelContainerView.a;

class EmojiStoreV2SingleProductUI$11 implements a {
    final /* synthetic */ EmojiStoreV2SingleProductUI lHL;

    EmojiStoreV2SingleProductUI$11(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.lHL = emojiStoreV2SingleProductUI;
    }

    public final void aDx() {
        if (EmojiStoreV2SingleProductUI.f(this.lHL) != null) {
            EmojiStoreV2SingleProductUI.f(this.lHL).clearFocus();
        }
        EmojiStoreV2SingleProductUI.f(this.lHL).requestFocus();
        EmojiStoreV2SingleProductUI.f(this.lHL).setVisibility(8);
        this.lHL.showOptionMenu(1001, EmojiStoreV2SingleProductUI.g(this.lHL));
        this.lHL.setMMTitle(R.l.eaG);
    }

    public final void aDy() {
        this.lHL.aWs();
    }
}
