package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.storage.emotion.EmojiInfo;

class EmojiStoreV2SingleProductDialogUI$8 implements Runnable {
    final /* synthetic */ EmojiStoreV2SingleProductDialogUI lHi;

    EmojiStoreV2SingleProductDialogUI$8(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        this.lHi = emojiStoreV2SingleProductDialogUI;
    }

    public final void run() {
        EmojiStoreV2SingleProductDialogUI.f(this.lHi).setVisibility(8);
        EmojiStoreV2SingleProductDialogUI.g(this.lHi).setVisibility(0);
        EmojiStoreV2SingleProductDialogUI.a(this.lHi, i.aBE().lwL.XU(EmojiStoreV2SingleProductDialogUI.a(this.lHi).vZL));
        if (EmojiStoreV2SingleProductDialogUI.h(this.lHi) == null || (EmojiStoreV2SingleProductDialogUI.h(this.lHi).field_reserved4 & EmojiInfo.xAz) != EmojiInfo.xAz) {
            EmojiStoreV2SingleProductDialogUI.g(this.lHi).cR(EmojiStoreV2SingleProductDialogUI.i(this.lHi), null);
        } else {
            EmojiStoreV2SingleProductDialogUI.g(this.lHi).g(((c) g.k(c.class)).getEmojiMgr().a(EmojiStoreV2SingleProductDialogUI.h(this.lHi)), "");
        }
        EmojiStoreV2SingleProductDialogUI.j(this.lHi);
        EmojiStoreV2SingleProductDialogUI.k(this.lHi).setEnabled(true);
        EmojiStoreV2SingleProductDialogUI.k(this.lHi).setTextColor(this.lHi.getResources().getColor(R.e.bsE));
    }
}
