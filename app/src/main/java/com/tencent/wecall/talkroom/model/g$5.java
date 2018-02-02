package com.tencent.wecall.talkroom.model;

import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.g.a;

class g$5 implements Runnable {
    final /* synthetic */ g AoK;
    final /* synthetic */ MultiTalkGroup oGC;

    g$5(g gVar, MultiTalkGroup multiTalkGroup) {
        this.AoK = gVar;
        this.oGC = multiTalkGroup;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a g : this.AoK.gxL) {
                g.g(this.oGC);
            }
        }
    }
}
