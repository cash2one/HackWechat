package com.tencent.mm.ui.chatting;

import com.tencent.mm.g.a.lx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class ChatFooterCustom$a extends c<lx> {
    final /* synthetic */ ChatFooterCustom yqX;

    private ChatFooterCustom$a(ChatFooterCustom chatFooterCustom) {
        this.yqX = chatFooterCustom;
        this.xen = lx.class.getName().hashCode();
    }

    /* synthetic */ ChatFooterCustom$a(ChatFooterCustom chatFooterCustom, byte b) {
        this(chatFooterCustom);
        this.xen = lx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lx lxVar = (lx) bVar;
        switch (lxVar.fDr.fDt) {
            case 0:
                this.yqX.j(1005, lxVar);
                break;
            case 1:
                this.yqX.j(1006, lxVar);
                break;
        }
        return false;
    }
}
