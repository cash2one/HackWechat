package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2DesignerUI$14 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiStoreV2DesignerUI lFV;

    EmojiStoreV2DesignerUI$14(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.lFV = emojiStoreV2DesignerUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "on shard click.");
        EmojiStoreV2DesignerUI.i(this.lFV);
        return true;
    }
}
