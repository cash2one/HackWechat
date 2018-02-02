package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.c;

class EmojiCustomUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiCustomUI lBU;

    EmojiCustomUI$5(EmojiCustomUI emojiCustomUI) {
        this.lBU = emojiCustomUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        EmojiCustomUI.a(this.lBU, c.lCf);
        return true;
    }
}
