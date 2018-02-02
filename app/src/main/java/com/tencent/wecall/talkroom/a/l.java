package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.f.g;
import com.tencent.pb.common.b.a.a.af;
import com.tencent.pb.common.b.a.a.i;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class l extends d {
    public long Anx;
    public int nJW;
    public String nln;

    public l(String str, int i, long j, int i2) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "NetSceneSwitchVideoGroup"});
        e iVar = new i();
        try {
            iVar.groupId = str;
            this.nln = str;
            iVar.nDx = i;
            this.nJW = i;
            iVar.nDy = j;
            this.Anx = j;
            iVar.action = i2;
            iVar.timestamp = System.currentTimeMillis();
            this.mYa = 3;
            this.zMg = com.tencent.wecall.talkroom.model.c.cHH().abW(str);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"NetSceneSwitchVideoGroup constructor", e});
        }
        c(g.CTRL_INDEX, iVar);
    }

    public final int getType() {
        return JsApiCheckIsSupportFaceDetect.CTRL_INDEX;
    }

    protected final Object bC(byte[] bArr) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "data2Resp"});
        if (bArr == null) {
            return null;
        }
        try {
            return (af) e.a(new af(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cCD() {
        return "CsCmd.Cmd_V_CSSwitchVideoGroupReq";
    }
}
