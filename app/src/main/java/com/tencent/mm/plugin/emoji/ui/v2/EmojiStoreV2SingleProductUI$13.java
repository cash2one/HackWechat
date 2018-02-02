package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import java.util.ArrayList;
import java.util.Collection;

class EmojiStoreV2SingleProductUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiStoreV2SingleProductUI lHL;

    EmojiStoreV2SingleProductUI$13(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.lHL = emojiStoreV2SingleProductUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (EmojiStoreV2SingleProductUI.f(this.lHL) != null) {
            EmojiStoreV2SingleProductUI.f(this.lHL).setVisibility(0);
            Collection arrayList = new ArrayList();
            arrayList.add(EmojiStoreV2SingleProductUI.l(this.lHL));
            EmojiStoreV2SingleProductUI.m(this.lHL).a(arrayList, EmojiStoreV2SingleProductUI.n(this.lHL));
            this.lHL.setMMTitle(R.l.eaS);
            this.lHL.showOptionMenu(1001, false);
            g.pQN.k(12788, "1");
        }
        return false;
    }
}
