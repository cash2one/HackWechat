package com.tencent.mm.plugin.emoji.ui;

class EmojiStoreDetailUI$2 implements Runnable {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$2(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final void run() {
        EmojiStoreDetailUI.m(this.lDM).fullScroll(130);
    }
}
