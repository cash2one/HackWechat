package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2SingleProductUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiStoreV2SingleProductUI lHL;

    EmojiStoreV2SingleProductUI$2(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.lHL = emojiStoreV2SingleProductUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "on shard click.");
        EmojiStoreV2SingleProductUI.o(this.lHL);
        return true;
    }
}
