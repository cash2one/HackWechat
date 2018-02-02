package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;

class f$8 implements Runnable {
    final /* synthetic */ f Aog;

    f$8(f fVar) {
        this.Aog = fVar;
    }

    public final void run() {
        if (this.Aog.bGq() && f.s(this.Aog)) {
            c.d("TalkRoomService", "syscall", "finishtalk becos holdtimeout");
            h.Je(-2003);
            this.Aog.AnF.Jh(401);
            this.Aog.ah(f.b(this.Aog), 3, 108);
        }
    }
}
