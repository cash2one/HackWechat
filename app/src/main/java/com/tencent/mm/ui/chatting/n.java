package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.p.b;

public final class n {
    private x fAh;
    boolean ypn;
    a yrW;
    q yrX;
    ChatFooter yrY;
    ChatFooterCustom yrZ;
    private boolean ysa = false;
    long[] ysb = null;

    public n(a aVar, q qVar, ChatFooter chatFooter, ChatFooterCustom chatFooterCustom, x xVar, boolean z, long[] jArr) {
        this.yrW = aVar;
        this.yrY = chatFooter;
        this.yrZ = chatFooterCustom;
        this.yrX = qVar;
        this.fAh = xVar;
        this.ypn = z;
        this.ysb = jArr;
        this.yrW.removeAllOptionMenu();
        this.yrW.addTextOptionMenu$7df2a0ca(2, this.yrW.getString(R.l.dMk), new 1(this), null, b.xJz);
        this.yrX.ytA = new 2(this);
    }
}
