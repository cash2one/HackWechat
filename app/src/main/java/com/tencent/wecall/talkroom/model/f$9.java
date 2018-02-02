package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.a.e;

class f$9 implements Runnable {
    final /* synthetic */ f Aog;

    f$9(f fVar) {
        this.Aog = fVar;
    }

    public final void run() {
        d dVar = null;
        String str = "TalkRoomService";
        Object[] objArr = new Object[6];
        objArr[0] = "beginSenceCircle state: ";
        objArr[1] = Integer.valueOf(f.a(this.Aog));
        objArr[2] = " mCircleScene: ";
        objArr[3] = f.t(this.Aog) == null ? null : Integer.valueOf(f.t(this.Aog).getType());
        objArr[4] = " mIsAck: ";
        objArr[5] = Boolean.valueOf(f.u(this.Aog));
        c.d(str, objArr);
        if (f.t(this.Aog) == null) {
            f.w(this.Aog).removeCallbacks(f.v(this.Aog));
            c.m("TalkRoomService", new Object[]{"beginSenceCircle removeCallbacks"});
        } else if (this.Aog.bGq()) {
            if (f.t(this.Aog) != null && f.t(this.Aog).getType() == 202 && f.a(this.Aog) == 3) {
                e eVar = (e) f.t(this.Aog);
                if (f.a(this.Aog, eVar.nln, eVar.nJW, eVar.Anx, f.Jc(eVar.Aps))) {
                    dVar = new e(eVar);
                    c.m("TalkRoomService", new Object[]{"beginSenceCircle enter"});
                }
            }
            if (dVar != null) {
                com.tencent.pb.common.b.e.cCE().a(dVar);
                return;
            }
            f.w(this.Aog).removeCallbacks(f.v(this.Aog));
            c.m("TalkRoomService", new Object[]{"beginSenceCircle removeCallbacks"});
        } else {
            f.w(this.Aog).removeCallbacks(f.v(this.Aog));
            c.m("TalkRoomService", new Object[]{"beginSenceCircle removeCallbacks"});
        }
    }
}
