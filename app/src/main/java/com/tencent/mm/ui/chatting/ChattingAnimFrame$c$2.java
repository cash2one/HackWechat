package com.tencent.mm.ui.chatting;

import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.ui.chatting.ChattingAnimFrame.c;

class ChattingAnimFrame$c$2 implements Runnable {
    final /* synthetic */ c yry;

    ChattingAnimFrame$c$2(c cVar) {
        this.yry = cVar;
    }

    public final void run() {
        if (this.yry.yrw != null) {
            this.yry.yrw.clearAnimation();
            ChattingAnimFrame chattingAnimFrame = this.yry.yrn;
            MMAnimateView mMAnimateView = this.yry.yrw;
            if (mMAnimateView != null && chattingAnimFrame.yrh != null) {
                chattingAnimFrame.yrh.remove(mMAnimateView);
                mMAnimateView.recycle();
                if (chattingAnimFrame.yrh.isEmpty()) {
                    mMAnimateView.setLayerType(0, null);
                    chattingAnimFrame.removeAllViews();
                    return;
                }
                mMAnimateView.setVisibility(4);
                mMAnimateView.setLayerType(0, null);
            }
        }
    }
}
