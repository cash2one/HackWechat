package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EmojiPaidUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiPaidUI lCx;

    EmojiPaidUI$1(EmojiPaidUI emojiPaidUI) {
        this.lCx = emojiPaidUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        EmojiPaidUI.a(this.lCx);
        return true;
    }
}
