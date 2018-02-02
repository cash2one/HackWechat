package com.tencent.mm.ui.bizchat;

import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.d.a;
import com.tencent.mm.ag.a.d.a.b;
import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.platformtools.x;

class BizChatFavUI$6 implements a {
    final /* synthetic */ BizChatFavUI ynN;

    BizChatFavUI$6(BizChatFavUI bizChatFavUI) {
        this.ynN = bizChatFavUI;
    }

    public final void a(b bVar) {
        if (bVar != null && bVar.hqQ != null) {
            x.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
            c ag = y.Mh().ag(bVar.hqF);
            x.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", new Object[]{Boolean.valueOf(ag.field_needToUpdate)});
            if (BizChatFavUI.b(this.ynN)) {
                BizChatFavUI.c(this.ynN).Xy();
            }
        }
    }
}
