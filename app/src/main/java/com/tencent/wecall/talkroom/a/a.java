package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.pb.common.b.a.a$ag;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.j;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class a extends d {
    public long Anx = 0;
    public int Apq;
    public int nJW = 0;
    public String nln = null;
    public int zMg;

    public a(String str, int i, long j, int i2, int i3) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "NetSceneAckVoiceGroup"});
        e jVar = new j();
        try {
            jVar.groupId = str;
            this.nln = str;
            jVar.slB = i;
            this.nJW = i;
            jVar.slC = j;
            this.Anx = j;
            this.Apq = i3;
            this.zMg = i2;
            al alVar = new al();
            alVar.wJB = 0;
            ba baVar = new ba();
            baVar.type = 3;
            baVar.zQb = alVar;
            jVar.zMQ = baVar;
            this.mYa = 3;
            this.zMg = i2;
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"NetSceneAckVoiceGroup constructor", e});
        }
        c(k.CTRL_BYTE, jVar);
    }

    public final int getType() {
        return b.CTRL_INDEX;
    }

    protected final Object bC(byte[] bArr) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "data2Resp"});
        if (bArr == null) {
            return null;
        }
        try {
            return (a$ag) e.a(new a$ag(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cCD() {
        return "CsCmd.Cmd_V_CSVoiceAckReq";
    }
}
