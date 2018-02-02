package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ui.o.a;
import com.tencent.mm.z.r;

class BizChatFavUI$9 implements a {
    final /* synthetic */ BizChatFavUI ynN;

    BizChatFavUI$9(BizChatFavUI bizChatFavUI) {
        this.ynN = bizChatFavUI;
    }

    public final void Xv() {
        this.ynN.setMMTitle(r.gu(BizChatFavUI.a(this.ynN)));
        if (BizChatFavUI.c(this.ynN).getCount() <= 0) {
            BizChatFavUI.d(this.ynN).setVisibility(0);
            BizChatFavUI.e(this.ynN).setVisibility(8);
            return;
        }
        BizChatFavUI.d(this.ynN).setVisibility(8);
        BizChatFavUI.e(this.ynN).setVisibility(0);
    }

    public final void Xw() {
    }
}
