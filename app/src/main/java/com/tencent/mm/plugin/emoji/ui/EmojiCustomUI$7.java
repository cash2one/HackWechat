package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class EmojiCustomUI$7 implements OnClickListener {
    final /* synthetic */ EmojiCustomUI lBU;

    EmojiCustomUI$7(EmojiCustomUI emojiCustomUI) {
        this.lBU = emojiCustomUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        EmojiCustomUI.j(this.lBU);
    }
}
