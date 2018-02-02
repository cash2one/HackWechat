package com.tencent.mm.plugin.emoji.ui.fts;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;

class FTSEmojiDetailPageUI$3 implements d {
    final /* synthetic */ FTSEmojiDetailPageUI lEU;

    FTSEmojiDetailPageUI$3(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        this.lEU = fTSEmojiDetailPageUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                FTSEmojiDetailPageUI.h(this.lEU);
                return;
            case 2:
                FTSEmojiDetailPageUI.g(this.lEU);
                return;
            default:
                return;
        }
    }
}
