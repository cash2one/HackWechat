package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EmojiSortUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiSortUI lCD;

    EmojiSortUI$1(EmojiSortUI emojiSortUI) {
        this.lCD = emojiSortUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lCD.finish();
        return true;
    }
}
