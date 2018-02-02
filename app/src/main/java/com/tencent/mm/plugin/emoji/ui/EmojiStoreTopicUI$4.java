package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.p.d;

class EmojiStoreTopicUI$4 implements d {
    final /* synthetic */ EmojiStoreTopicUI lDW;

    EmojiStoreTopicUI$4(EmojiStoreTopicUI emojiStoreTopicUI) {
        this.lDW = emojiStoreTopicUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1000:
                Context context = this.lDW.mController.xIM;
                String a = EmojiStoreTopicUI.a(this.lDW);
                String e = EmojiStoreTopicUI.e(this.lDW);
                String b = EmojiStoreTopicUI.b(this.lDW);
                i.aBA();
                k.a(context, a, e, b, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(EmojiStoreTopicUI.d(this.lDW), EmojiStoreTopicUI.a(this.lDW), EmojiStoreTopicUI.e(this.lDW), EmojiStoreTopicUI.b(this.lDW), EmojiStoreTopicUI.f(this.lDW), 0), 13);
                g.pQN.h(13224, new Object[]{Integer.valueOf(1), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreTopicUI.d(this.lDW))});
                return;
            case 1001:
                k.cu(this.lDW.mController.xIM);
                this.lDW.mController.xIM.overridePendingTransition(R.a.bqo, R.a.bqa);
                g.pQN.h(13224, new Object[]{Integer.valueOf(1), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreTopicUI.d(this.lDW))});
                return;
            default:
                return;
        }
    }
}
