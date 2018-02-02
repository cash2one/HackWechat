package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class f extends d {
    public f(String str, int i, long j, int i2) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "eixt", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)});
        e fVar = new com.tencent.pb.common.b.a.a.f();
        try {
            fVar.groupId = str;
            fVar.slB = i;
            fVar.slC = j;
            fVar.aAk = i2;
            this.mYa = 2;
            this.zMg = com.tencent.wecall.talkroom.model.c.cHH().abW(str);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"NetSceneExitVoiceRoom constructor", e});
        }
        c(143, fVar);
    }

    public final int getType() {
        return 203;
    }

    protected final Object bC(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (ab) e.a(new ab(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cCD() {
        return "CsCmd.Cmd_V_CSExitVoiceRoomReq";
    }
}
