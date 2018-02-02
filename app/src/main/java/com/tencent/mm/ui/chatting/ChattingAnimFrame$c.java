package com.tencent.mm.ui.chatting;

import android.view.animation.AnimationSet;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.ui.chatting.ChattingAnimFrame.b;

class ChattingAnimFrame$c extends AnimationSet {
    int hX;
    final /* synthetic */ ChattingAnimFrame yrn;
    private long yrv;
    MMAnimateView yrw;

    static /* synthetic */ void a(ChattingAnimFrame$c chattingAnimFrame$c) {
        chattingAnimFrame$c.setStartOffset(chattingAnimFrame$c.yrv);
        chattingAnimFrame$c.start();
    }

    public ChattingAnimFrame$c(ChattingAnimFrame chattingAnimFrame, int i, int i2, long j, boolean z) {
        this.yrn = chattingAnimFrame;
        super(false);
        this.hX = i2;
        switch (i) {
            case 0:
            case 1:
                addAnimation(new b(chattingAnimFrame, i, this.hX));
                break;
            case 2:
                addAnimation(new b(chattingAnimFrame, 999, this.hX));
                addAnimation(new b(chattingAnimFrame, i, this.hX));
                break;
            case 3:
                addAnimation(new b(chattingAnimFrame, i, this.hX, z));
                addAnimation(new b(chattingAnimFrame, 999, this.hX));
                break;
            default:
                addAnimation(new b(chattingAnimFrame, 0, this.hX));
                break;
        }
        setAnimationListener(new 1(this, chattingAnimFrame));
        this.yrv = 500 + j;
        reset();
        setDuration(ChattingAnimFrame.Fr(i));
    }
}
