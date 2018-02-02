package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.p.d;

class EmojiStoreV2DesignerUI$6 implements d {
    final /* synthetic */ EmojiStoreV2DesignerUI lFV;

    EmojiStoreV2DesignerUI$6(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        this.lFV = emojiStoreV2DesignerUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1000:
                if (EmojiStoreV2DesignerUI.l(this.lFV) != null) {
                    k.a(this.lFV.mController.xIM, EmojiStoreV2DesignerUI.l(this.lFV).nfp + this.lFV.getString(R.l.ear), EmojiStoreV2DesignerUI.l(this.lFV).nfe, EmojiStoreV2DesignerUI.l(this.lFV).waN, EmojiStoreV2DesignerUI.m(this.lFV), EmojiLogic.i(EmojiStoreV2DesignerUI.k(this.lFV), EmojiStoreV2DesignerUI.n(this.lFV), EmojiStoreV2DesignerUI.m(this.lFV)), 10);
                    g.pQN.h(13224, new Object[]{Integer.valueOf(3), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreV2DesignerUI.k(this.lFV))});
                    return;
                }
                return;
            case 1001:
                k.cu(this.lFV.mController.xIM);
                this.lFV.mController.xIM.overridePendingTransition(R.a.bqo, R.a.bqa);
                g.pQN.h(13224, new Object[]{Integer.valueOf(3), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreV2DesignerUI.k(this.lFV))});
                return;
            default:
                return;
        }
    }
}
