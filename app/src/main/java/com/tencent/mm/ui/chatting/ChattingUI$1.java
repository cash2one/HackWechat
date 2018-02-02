package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ChattingUI$1 implements Runnable {
    final /* synthetic */ ChattingUI yvG;

    ChattingUI$1(ChattingUI chattingUI) {
        this.yvG = chattingUI;
    }

    public final void run() {
        h.a(this.yvG, this.yvG.getString(R.l.eyT), "", this.yvG.getString(R.l.eyU), this.yvG.getString(R.l.dEn), new 1(this), new 2(this));
    }
}
