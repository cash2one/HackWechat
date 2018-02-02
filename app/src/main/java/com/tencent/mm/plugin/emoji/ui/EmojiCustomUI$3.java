package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EmojiCustomUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiCustomUI lBU;

    EmojiCustomUI$3(EmojiCustomUI emojiCustomUI) {
        this.lBU = emojiCustomUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lBU.finish();
        return true;
    }
}
