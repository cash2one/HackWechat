package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.af.a;

class as$2 extends a {
    as$2() {
    }

    public final boolean aj(int i, boolean z) {
        x.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        if (z) {
            return false;
        }
        return true;
    }
}
