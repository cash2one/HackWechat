package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a$aj;
import com.tencent.pb.common.b.a.a.k;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class h extends d {
    public String groupId;
    public int nDx;
    public long nDy;

    public h(String str, int i, long j, int i2) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "NetSceneRejectVoiceGroup"});
        e kVar = new k();
        try {
            kVar.groupId = str;
            kVar.slB = i;
            kVar.slC = j;
            kVar.nEd = i2;
            kVar.zMS = 2;
            kVar.netType = com.tencent.wecall.talkroom.model.k.iM(com.tencent.pb.common.c.d.ssG);
            this.mYa = 3;
            this.zMg = com.tencent.wecall.talkroom.model.c.cHH().abW(str);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"NetSceneRedirect constructor", e});
        }
        c(com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, kVar);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX;
    }

    protected final Object bC(byte[] bArr) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "data2Resp"});
        if (bArr == null) {
            return null;
        }
        try {
            return (a$aj) e.a(new a$aj(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cCD() {
        return "CsCmd.Cmd_V_CSVoiceRedirectReq";
    }
}
