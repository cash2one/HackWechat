package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EmojiMineUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiMineUI lCv;

    EmojiMineUI$1(EmojiMineUI emojiMineUI) {
        this.lCv = emojiMineUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lCv.finish();
        return true;
    }
}
