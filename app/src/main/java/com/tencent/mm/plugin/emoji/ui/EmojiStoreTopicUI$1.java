package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreTopicUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiStoreTopicUI lDW;

    EmojiStoreTopicUI$1(EmojiStoreTopicUI emojiStoreTopicUI) {
        this.lDW = emojiStoreTopicUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
        if (bh.ov(EmojiStoreTopicUI.a(this.lDW)) || bh.ov(EmojiStoreTopicUI.b(this.lDW))) {
            x.i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
        } else {
            EmojiStoreTopicUI.c(this.lDW);
        }
        return true;
    }
}
