package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.plugin.bottle.ui.BottleConversationUI.3;
import com.tencent.mm.z.ba.a;

class BottleConversationUI$3$2 implements a {
    final /* synthetic */ 3 kBT;

    BottleConversationUI$3$2(3 3) {
        this.kBT = 3;
    }

    public final boolean HB() {
        return BottleConversationUI.f(this.kBT.kBS);
    }

    public final void HA() {
        if (BottleConversationUI.g(this.kBT.kBS) != null) {
            BottleConversationUI.g(this.kBT.kBS).dismiss();
            BottleConversationUI.a(this.kBT.kBS, null);
        }
    }
}
