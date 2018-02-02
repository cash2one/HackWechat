package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.c;
import com.tencent.pb.talkroom.sdk.b;
import java.util.concurrent.atomic.AtomicInteger;

class f$6 implements b {
    final /* synthetic */ f Aog;
    final /* synthetic */ AtomicInteger Aoq;
    final /* synthetic */ AtomicInteger Aor;

    f$6(f fVar, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
        this.Aog = fVar;
        this.Aoq = atomicInteger;
        this.Aor = atomicInteger2;
    }

    public final int P(byte[] bArr, int i) {
        if (!f.l(this.Aog)) {
            return 0;
        }
        try {
            int GetAudioData = !a.zLH ? 1 : f.c(this.Aog).AmY.GetAudioData(bArr, (short) i, this.Aoq, this.Aor);
            if (this.Aog.AnV && GetAudioData >= 0) {
                this.Aog.AnV = false;
                c.m("TalkRoomService", new Object[]{"onPlayPcmDataCallBack len: ", Integer.valueOf(i), " ret: ", Integer.valueOf(GetAudioData)});
            }
            return GetAudioData;
        } catch (Exception e) {
            c.m("TalkRoomService", new Object[]{"initMediaComponent play", e});
            return -1;
        }
    }
}
