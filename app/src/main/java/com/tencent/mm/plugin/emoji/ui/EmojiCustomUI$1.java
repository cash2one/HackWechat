package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.model.i;

class EmojiCustomUI$1 implements OnClickListener {
    final /* synthetic */ EmojiCustomUI lBU;

    EmojiCustomUI$1(EmojiCustomUI emojiCustomUI) {
        this.lBU = emojiCustomUI;
    }

    public final void onClick(View view) {
        switch (EmojiCustomUI$10.lBW[EmojiCustomUI.a(this.lBU).ordinal()]) {
            case 2:
                EmojiCustomUI.b(this.lBU);
                return;
            case 3:
                i.aBB().lzq.aCa();
                return;
            default:
                return;
        }
    }
}
