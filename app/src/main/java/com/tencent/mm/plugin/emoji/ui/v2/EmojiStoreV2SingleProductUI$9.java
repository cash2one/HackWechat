package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;

class EmojiStoreV2SingleProductUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiStoreV2SingleProductUI lHL;

    EmojiStoreV2SingleProductUI$9(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.lHL = emojiStoreV2SingleProductUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (EmojiStoreV2SingleProductUI.f(this.lHL) == null || EmojiStoreV2SingleProductUI.f(this.lHL).getVisibility() != 0) {
            this.lHL.finish();
        } else {
            EmojiStoreV2SingleProductUI.f(this.lHL).setVisibility(8);
            this.lHL.showOptionMenu(1001, EmojiStoreV2SingleProductUI.g(this.lHL));
            this.lHL.setMMTitle(R.l.eaG);
        }
        return false;
    }
}
