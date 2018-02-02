package com.tencent.wecall.talkroom.a;

import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.pb.common.b.a.a$aa;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class e extends d {
    public long Anx = 0;
    public int Aps = 0;
    public int nJW = 0;
    public String nln = null;

    public e(e eVar) {
        this.nln = eVar.nln;
        this.nJW = eVar.nJW;
        this.Anx = eVar.Anx;
        this.Aps = eVar.Aps;
        this.zMd = eVar.zMd;
        this.zMf = eVar.zMf;
        this.zMg = eVar.zMg;
        this.mYa = 1;
    }

    public e(String str, int i, long j, byte[] bArr, int i2, int i3) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "enter", str, Integer.valueOf(i), Long.valueOf(j)});
        com.google.a.a.e eVar = new com.tencent.pb.common.b.a.a.e();
        try {
            eVar.groupId = str;
            this.nln = str;
            eVar.slB = i;
            this.nJW = i;
            eVar.slC = j;
            this.Anx = j;
            eVar.zMY = i3;
            this.Aps = i3;
            al alVar = new al();
            if (bArr != null) {
                alVar.buffer = bArr;
                alVar.wJB = bArr.length;
            } else {
                alVar.wJB = 0;
            }
            ba baVar = new ba();
            baVar.type = 3;
            baVar.zQb = alVar;
            eVar.zMQ = baVar;
            this.mYa = 2;
            this.zMg = i2;
            eVar.zMS = 2;
            eVar.netType = k.iM(com.tencent.pb.common.c.d.ssG);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"NetSceneEnterVoiceRoom constructor", e});
        }
        c(j.CTRL_INDEX, eVar);
    }

    public final int getType() {
        return 202;
    }

    protected final Object bC(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (a$aa) com.google.a.a.e.a(new a$aa(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cCD() {
        return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
    }
}
