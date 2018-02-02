package com.tencent.wecall.talkroom.model;

import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.c;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    talk AmY = new talk();

    public b() {
        c.d("simon:TalkRoomContext", new Object[]{"construct"});
    }

    public final int uninitLive() {
        if (!a.zLH) {
            return 0;
        }
        int uninit;
        try {
            uninit = this.AmY.uninit();
        } catch (Throwable th) {
            c.m("simon:TalkRoomContext", new Object[]{"uninitLive ", th});
            uninit = 0;
        }
        c.d("simon:TalkRoomContext", new Object[]{"uninitLive ret: ", Integer.valueOf(uninit)});
        return uninit;
    }

    public final int Close() {
        if (!a.zLH) {
            return 0;
        }
        int close;
        try {
            close = this.AmY.close();
        } catch (Throwable th) {
            c.m("simon:TalkRoomContext", new Object[]{"Close ", th});
            close = 0;
        }
        c.d("simon:TalkRoomContext", new Object[]{"Close ret: ", Integer.valueOf(close)});
        return close;
    }

    public final void OnMembersChanged(int[] iArr) {
        if (a.zLH) {
            this.AmY.OnMembersChanged(iArr);
        }
    }

    public final byte[] cHF() {
        if (a.zLH) {
            return this.AmY.field_capInfo;
        }
        return new byte[0];
    }

    public final int cHG() {
        int i = 0;
        try {
            if (a.zLH) {
                AtomicInteger atomicInteger = new AtomicInteger();
                AtomicInteger atomicInteger2 = new AtomicInteger();
                this.AmY.getChannelBytes(atomicInteger, atomicInteger2);
                i = atomicInteger2.get();
            }
        } catch (Throwable th) {
            c.m("simon:TalkRoomContext", new Object[]{"getTotalWWANBytes: ", th});
        }
        return i;
    }
}
