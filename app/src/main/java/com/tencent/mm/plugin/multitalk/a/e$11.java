package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;

class e$11 implements Runnable {
    final /* synthetic */ MultiTalkGroup oGC;
    final /* synthetic */ e oGz;

    e$11(e eVar, MultiTalkGroup multiTalkGroup) {
        this.oGz = eVar;
        this.oGC = multiTalkGroup;
    }

    public final void run() {
        String str = this.oGC.zQq;
        if (bh.ov(str)) {
            str = this.oGC.zQr;
        }
        o.bcU().oFQ.Fy(str);
    }
}
