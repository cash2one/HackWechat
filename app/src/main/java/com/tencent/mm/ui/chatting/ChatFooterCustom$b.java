package com.tencent.mm.ui.chatting;

import com.tencent.mm.g.a.ly;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class ChatFooterCustom$b extends c<ly> {
    final /* synthetic */ ChatFooterCustom yqX;

    private ChatFooterCustom$b(ChatFooterCustom chatFooterCustom) {
        this.yqX = chatFooterCustom;
        this.xen = ly.class.getName().hashCode();
    }

    /* synthetic */ ChatFooterCustom$b(ChatFooterCustom chatFooterCustom, byte b) {
        this(chatFooterCustom);
        this.xen = ly.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ly lyVar = (ly) bVar;
        switch (lyVar.fDv.fDt) {
            case 0:
                this.yqX.j(1004, lyVar);
                break;
            case 1:
                this.yqX.j(1003, lyVar);
                break;
        }
        return false;
    }
}
