package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.al.h;

abstract class al$b extends b {
    protected h yOl;

    al$b() {
    }

    protected final h A(a aVar) {
        if (this.yOl == null) {
            this.yOl = new h(aVar);
        }
        return this.yOl;
    }

    public boolean aXj() {
        return true;
    }
}
