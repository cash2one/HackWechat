package com.tencent.wecall.talkroom.model;

import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.g.a;

class g$6 implements Runnable {
    final /* synthetic */ g AoK;
    final /* synthetic */ MultiTalkGroup oGC;

    g$6(g gVar, MultiTalkGroup multiTalkGroup) {
        this.AoK = gVar;
        this.oGC = multiTalkGroup;
    }

    public final void run() {
        synchronized (this.AoK.gxL) {
            for (a p : this.AoK.gxL) {
                p.p(this.oGC);
            }
        }
    }
}
