package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.emoji.f.g;

class EmojiStoreDetailUI$10 implements OnClickListener {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$10(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        EmojiStoreDetailUI.a(this.lDM, new g(EmojiStoreDetailUI.a(this.lDM), EmojiStoreDetailUI.B(this.lDM), EmojiStoreDetailUI.C(this.lDM)));
        EmojiStoreDetailUI.D(this.lDM);
        EmojiStoreDetailUI.a(this.lDM, 6);
        EmojiStoreDetailUI.g(this.lDM);
    }
}
