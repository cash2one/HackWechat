package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ae;
import com.tencent.pb.common.b.a.a.h;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class k extends d {
    public long Anx;
    public int nJW;
    public String nln;

    public k(String str, int i, long j, String str2) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "NetSceneSubscribeLargeVideo"});
        e hVar = new h();
        try {
            hVar.groupId = str;
            this.nln = str;
            hVar.nDx = i;
            this.nJW = i;
            hVar.nDy = j;
            this.Anx = j;
            hVar.ldj = str2;
            hVar.timestamp = System.currentTimeMillis();
            c.l("MicroMsg.Voip", new Object[]{"roomId: %d, roomKey: %d, groupId: %s, ownerUserName: %s, timestamp: %d", Integer.valueOf(hVar.nDx), Long.valueOf(hVar.nDy), hVar.groupId, hVar.ldj, Long.valueOf(hVar.timestamp)});
            this.mYa = 3;
            this.zMg = com.tencent.wecall.talkroom.model.c.cHH().abW(str);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"NetSceneSwitchVideoGroup constructor", e});
        }
        c(245, hVar);
    }

    public final int getType() {
        return 800;
    }

    protected final Object bC(byte[] bArr) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "data2Resp"});
        if (bArr == null) {
            return null;
        }
        try {
            return (ae) e.a(new ae(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cCD() {
        return "CsCmd.Cmd_V_CSSubscribeLargeVideoReq";
    }
}
