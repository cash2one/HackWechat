package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

class EmojiStoreV2SingleProductDialogUI$6 implements a {
    final /* synthetic */ EmojiStoreV2SingleProductDialogUI lHi;

    EmojiStoreV2SingleProductDialogUI$6(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        this.lHi = emojiStoreV2SingleProductDialogUI;
    }

    public final void h(EmojiInfo emojiInfo) {
        if (emojiInfo == null || EmojiStoreV2SingleProductDialogUI.a(this.lHi) == null || !EmojiStoreV2SingleProductDialogUI.a(this.lHi).vZL.equals(emojiInfo.Nr())) {
            x.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "somethings error.");
        } else {
            EmojiStoreV2SingleProductDialogUI.e(this.lHi);
        }
    }
}
