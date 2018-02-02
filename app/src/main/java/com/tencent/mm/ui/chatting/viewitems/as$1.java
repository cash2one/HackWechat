package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.af.b;

class as$1 extends b {
    as$1() {
    }

    public final boolean aj(int i, boolean z) {
        x.w("MicroMsg.Chatting.ItemFactory", "unfound msgType:%d, isSender:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        return z;
    }
}
