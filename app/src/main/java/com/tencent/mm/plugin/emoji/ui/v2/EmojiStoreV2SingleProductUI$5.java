package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.p$d;

class EmojiStoreV2SingleProductUI$5 implements p$d {
    final /* synthetic */ EmojiStoreV2SingleProductUI lHL;

    EmojiStoreV2SingleProductUI$5(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.lHL = emojiStoreV2SingleProductUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1000:
                Context context = this.lHL.mController.xIM;
                String r = EmojiStoreV2SingleProductUI.r(this.lHL);
                String s = EmojiStoreV2SingleProductUI.s(this.lHL);
                String t = EmojiStoreV2SingleProductUI.t(this.lHL);
                i.aBA();
                k.a(context, r, s, t, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(EmojiStoreV2SingleProductUI.q(this.lHL), EmojiStoreV2SingleProductUI.r(this.lHL), EmojiStoreV2SingleProductUI.s(this.lHL), EmojiStoreV2SingleProductUI.t(this.lHL), EmojiStoreV2SingleProductUI.u(this.lHL), EmojiStoreV2SingleProductUI.v(this.lHL)), 12);
                g.pQN.h(13224, new Object[]{Integer.valueOf(2), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreV2SingleProductUI.q(this.lHL))});
                return;
            case 1001:
                k.cu(this.lHL.mController.xIM);
                this.lHL.mController.xIM.overridePendingTransition(R.a.bqo, R.a.bqa);
                g.pQN.h(13224, new Object[]{Integer.valueOf(2), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreV2SingleProductUI.q(this.lHL))});
                return;
            default:
                return;
        }
    }
}
