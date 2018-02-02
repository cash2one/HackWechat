package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.a.a;
import com.tencent.pb.talkroom.sdk.c;

class f$5 implements c {
    final /* synthetic */ f Aog;

    f$5(f fVar) {
        this.Aog = fVar;
    }

    public final void Q(byte[] bArr, int i) {
        try {
            if (f.l(this.Aog)) {
                if (f.m(this.Aog)) {
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr[i2] = (byte) 0;
                    }
                }
                if (f.l(this.Aog)) {
                    b c = f.c(this.Aog);
                    short s = (short) i;
                    if (a.zLH) {
                        c.AmY.SendAudio(bArr, s, 0);
                    }
                    if (this.Aog.AnU) {
                        this.Aog.AnU = false;
                        com.tencent.pb.common.c.c.m("TalkRoomService", new Object[]{"onRecPcmDataCallBack len: ", Integer.valueOf(i)});
                    }
                }
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m("TalkRoomService", new Object[]{"initMediaComponent record", e});
        }
    }
}
