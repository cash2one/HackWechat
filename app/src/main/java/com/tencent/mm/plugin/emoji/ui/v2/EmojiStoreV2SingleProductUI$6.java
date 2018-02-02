package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.g.a.cq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class EmojiStoreV2SingleProductUI$6 extends c<cq> {
    final /* synthetic */ EmojiStoreV2SingleProductUI lHL;

    EmojiStoreV2SingleProductUI$6(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.lHL = emojiStoreV2SingleProductUI;
        this.xen = cq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!(EmojiStoreV2SingleProductUI.c(this.lHL) == null || EmojiStoreV2SingleProductUI.d(this.lHL) == null)) {
            EmojiStoreV2SingleProductUI.d(this.lHL).post(new 1(this));
        }
        return false;
    }
}
