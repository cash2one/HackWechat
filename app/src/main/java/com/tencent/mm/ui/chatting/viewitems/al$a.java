package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;

abstract class al$a extends b {
    protected al$h yOl;

    al$a() {
    }

    protected final al$h A(a aVar) {
        if (this.yOl == null) {
            this.yOl = new al$h(aVar);
        }
        return this.yOl;
    }

    public String a(a aVar, au auVar) {
        return aVar.ysf.talker;
    }

    public boolean aXj() {
        return false;
    }
}
