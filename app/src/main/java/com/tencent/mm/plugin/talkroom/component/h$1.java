package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.x;

class h$1 implements Runnable {
    final /* synthetic */ PInt saN;
    final /* synthetic */ PInt saO;
    final /* synthetic */ boolean saP;
    final /* synthetic */ h saQ;

    h$1(h hVar, PInt pInt, PInt pInt2, boolean z) {
        this.saQ = hVar;
        this.saN = pInt;
        this.saO = pInt2;
        this.saP = z;
    }

    public final void run() {
        h.a(this.saQ, true);
        try {
            h.a(this.saQ).j(this.saN.value, this.saO.value, this.saP);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e, "", new Object[0]);
        }
        h.a(this.saQ, false);
    }
}
