package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreDetailUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$7(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "on shard click.");
        EmojiStoreDetailUI.u(this.lDM);
        return true;
    }
}
