package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.pb.common.b.a.a.ak;
import com.tencent.pb.common.b.a.a.l;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class m extends d {
    public long Anx;
    public int nJW;
    public String nln;

    public m(String str, int i, long j, int i2, int i3) {
        c.d("MicroMsg.Voip", this.TAG2, "hello", str, Integer.valueOf(i), Long.valueOf(j));
        e lVar = new l();
        lVar.zNd = i3;
        lVar.slB = i;
        this.nJW = i;
        lVar.slC = j;
        this.Anx = j;
        lVar.groupId = str;
        this.nln = str;
        lVar.nEd = i2;
        try {
            this.zMg = com.tencent.wecall.talkroom.model.c.cHH().abW(str);
        } catch (Exception e) {
            c.m(this.TAG2, "NetSceneVoiceRoomHello constructor", e);
        }
        c(147, lVar);
    }

    public final int getType() {
        return g.CTRL_INDEX;
    }

    protected final Object bC(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (ak) e.a(new ak(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String cCD() {
        return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
    }
}
