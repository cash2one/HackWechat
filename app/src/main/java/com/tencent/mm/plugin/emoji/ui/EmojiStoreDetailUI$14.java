package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.p.d;

class EmojiStoreDetailUI$14 implements d {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    EmojiStoreDetailUI$14(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1000:
                k.a(this.lDM.mController.xIM, EmojiStoreDetailUI.b(this.lDM).war + this.lDM.getString(R.l.eaU), EmojiStoreDetailUI.b(this.lDM).was, EmojiStoreDetailUI.b(this.lDM).nfT, EmojiStoreDetailUI.b(this.lDM).waK, EmojiLogic.yo(EmojiStoreDetailUI.a(this.lDM)), 4);
                g.pQN.h(13224, new Object[]{Integer.valueOf(0), Integer.valueOf(1), EmojiStoreDetailUI.a(this.lDM), ""});
                return;
            case 1001:
                k.cu(this.lDM.mController.xIM);
                this.lDM.mController.xIM.overridePendingTransition(R.a.bqo, R.a.bqa);
                g.pQN.h(13224, new Object[]{Integer.valueOf(0), Integer.valueOf(2), EmojiStoreDetailUI.a(this.lDM), ""});
                return;
            default:
                return;
        }
    }
}
