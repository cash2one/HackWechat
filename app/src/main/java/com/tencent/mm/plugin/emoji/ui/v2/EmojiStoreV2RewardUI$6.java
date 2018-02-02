package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EmojiStoreV2RewardUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiStoreV2RewardUI lGQ;

    EmojiStoreV2RewardUI$6(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        this.lGQ = emojiStoreV2RewardUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lGQ.onBackPressed();
        return true;
    }
}
