package com.tencent.mm.plugin.emoji.ui.fts;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FTSEmojiDetailPageUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FTSEmojiDetailPageUI lEU;

    FTSEmojiDetailPageUI$1(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        this.lEU = fTSEmojiDetailPageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lEU.finish();
        return false;
    }
}
