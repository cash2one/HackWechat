package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.a.m;
import java.util.TimerTask;

class f$3 extends TimerTask {
    final /* synthetic */ f Aog;
    final /* synthetic */ m Aoh;

    f$3(f fVar, m mVar) {
        this.Aog = fVar;
        this.Aoh = mVar;
    }

    public final void run() {
        if (this.Aoh == null) {
            c.m("TalkRoomService", new Object[]{"doHelloTimeOutTask scene is null"});
        } else if (f.a(this.Aog, this.Aoh.nln, this.Aoh.nJW, this.Aoh.Anx, false)) {
            c.m("TalkRoomService", new Object[]{"doHelloTimeOutTask mGroupId: ", f.b(this.Aog), " mRoomId: ", Integer.valueOf(f.g(this.Aog)), " mRoomKey: ", Long.valueOf(f.h(this.Aog))});
            this.Aog.AnF.Jh(330);
            h.Jd(-1606);
            this.Aog.a(this.Aoh.nln, this.Aoh.nJW, this.Aoh.Anx, 117, true);
            f.f(this.Aog).g(-600, null);
        } else {
            c.m("TalkRoomService", new Object[]{"doHelloTimeOutTask isCurrentRoom is false scene.mGroupId: ", this.Aoh.nln, " scene.mRoomId: ", Integer.valueOf(this.Aoh.nJW), " scene.mRoomKey: ", Long.valueOf(this.Aoh.Anx)});
        }
    }
}
