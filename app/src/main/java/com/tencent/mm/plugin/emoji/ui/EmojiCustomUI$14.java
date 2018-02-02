package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.c.a;

class EmojiCustomUI$14 extends a {
    final /* synthetic */ EmojiCustomUI lBU;

    EmojiCustomUI$14(EmojiCustomUI emojiCustomUI) {
        this.lBU = emojiCustomUI;
    }

    public final void aCd() {
        EmojiCustomUI.a(this.lBU, i.aBB().aBY());
        if (EmojiCustomUI.f(this.lBU) != null) {
            EmojiCustomUI.f(this.lBU).sendEmptyMessage(1001);
        }
    }

    public final void aCe() {
        if (EmojiCustomUI.f(this.lBU) != null) {
            EmojiCustomUI.f(this.lBU).sendEmptyMessage(1002);
        }
    }
}
