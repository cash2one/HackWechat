package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.e;

class BottleConversationUI$6 implements e {
    final /* synthetic */ BottleConversationUI kBS;

    BottleConversationUI$6(BottleConversationUI bottleConversationUI) {
        this.kBS = bottleConversationUI;
    }

    public final void bo(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
        } else {
            BottleConversationUI.a(this.kBS, obj.toString());
        }
    }
}
