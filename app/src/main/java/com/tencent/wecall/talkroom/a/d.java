package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class d extends com.tencent.pb.common.b.d {
    public String Anw;
    public boolean Apr = true;
    public int mType;

    public d(String str, String[] strArr, byte[] bArr, String str2, ay ayVar, int i, int i2, long j, String str3, boolean z, String str4) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "create"});
        e dVar = new com.tencent.pb.common.b.a.a.d();
        try {
            dVar.zMM = str;
            this.Anw = str;
            dVar.zMR = i;
            this.zMg = i;
            if (ayVar != null) {
                dVar.zMT = ayVar;
            }
            at atVar = new at();
            atVar.name = str2;
            atVar.zPg = str4;
            atVar.zPf = a.cCV();
            atVar.fvx = i2;
            this.mType = i2;
            this.Apr = z;
            atVar.zOY = j;
            dVar.zMO = atVar;
            dVar.zMV = strArr;
            if (str3 == null) {
                str3 = "";
            }
            dVar.zMU = str3;
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
            dVar.zMQ = baVar;
            this.mYa = 3;
            dVar.zMS = 2;
            dVar.netType = k.iM(com.tencent.pb.common.c.d.ssG);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"NetSceneCreateVoiceGroup constructor", e});
        }
        c(v.CTRL_INDEX, dVar);
    }

    public final int getType() {
        return 201;
    }

    protected final Object bC(byte[] bArr) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "data2Resp"});
        if (bArr == null) {
            return null;
        }
        try {
            return (z) e.a(new z(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cCD() {
        return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
    }
}
