package com.tencent.mm.plugin.emoji.ui;

class EmojiStoreVpHeader$1 implements Runnable {
    final /* synthetic */ EmojiStoreVpHeader lEg;

    EmojiStoreVpHeader$1(EmojiStoreVpHeader emojiStoreVpHeader) {
        this.lEg = emojiStoreVpHeader;
    }

    public final void run() {
        if (EmojiStoreVpHeader.a(this.lEg) != null && EmojiStoreVpHeader.b(this.lEg) != null) {
            EmojiStoreVpHeader.a(this.lEg).H(EmojiStoreVpHeader.b(this.lEg));
        }
    }
}
