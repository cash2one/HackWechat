package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MMTagPanel$a;

class EmojiStoreV2SingleProductUI$12 implements MMTagPanel$a {
    final /* synthetic */ EmojiStoreV2SingleProductUI lHL;

    EmojiStoreV2SingleProductUI$12(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.lHL = emojiStoreV2SingleProductUI;
    }

    public final void yI(String str) {
        if (!bh.ov(EmojiStoreV2SingleProductUI.l(this.lHL)) && !bh.ov(str) && str.equals(EmojiStoreV2SingleProductUI.l(this.lHL))) {
            EmojiStoreV2SingleProductUI.m(this.lHL).bj(EmojiStoreV2SingleProductUI.l(this.lHL), true);
        }
    }

    public final void yJ(String str) {
        EmojiStoreV2SingleProductUI.a(this.lHL, str);
    }

    public final void yK(String str) {
    }

    public final void j(boolean z, int i) {
    }

    public final void aDz() {
    }

    public final void yL(String str) {
    }

    public final void yM(String str) {
    }
}
