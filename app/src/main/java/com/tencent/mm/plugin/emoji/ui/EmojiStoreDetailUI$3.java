package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EmojiStoreDetailUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$3(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lDM.finish();
        return true;
    }
}
