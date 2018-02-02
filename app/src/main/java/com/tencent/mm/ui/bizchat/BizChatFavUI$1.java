package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ag.a.b$a;
import com.tencent.mm.ag.a.b$a.b;
import com.tencent.mm.sdk.platformtools.x;

class BizChatFavUI$1 implements b$a {
    final /* synthetic */ BizChatFavUI ynN;

    BizChatFavUI$1(BizChatFavUI bizChatFavUI) {
        this.ynN = bizChatFavUI;
    }

    public final void a(b bVar) {
        if (bVar != null && bVar.hqG != null && BizChatFavUI.a(this.ynN).equals(bVar.hqG.field_brandUserName)) {
            x.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
            if (BizChatFavUI.b(this.ynN)) {
                BizChatFavUI.c(this.ynN).Xy();
            }
        }
    }
}
