package com.tencent.mm.ui.chatting;

import android.view.animation.Animation;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingAnimFrame.a;
import com.tencent.mm.ui.chatting.ChattingAnimFrame.c;
import com.tencent.mm.ui.chatting.ChattingAnimFrame.c.2;

class ChattingAnimFrame$c$1 extends a {
    final /* synthetic */ ChattingAnimFrame yrx;
    final /* synthetic */ c yry;

    ChattingAnimFrame$c$1(c cVar, ChattingAnimFrame chattingAnimFrame) {
        this.yry = cVar;
        this.yrx = chattingAnimFrame;
        super(cVar.yrn);
    }

    public final void onAnimationEnd(Animation animation) {
        c cVar = this.yry;
        if (cVar.yrw != null) {
            cVar.yrw.post(new 2(cVar));
        } else {
            x.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
        }
    }
}
