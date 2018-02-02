package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class b extends d {
    public long Anx;
    public int nJW;
    public String nln;

    public b(String str, int i, long j, String[] strArr) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "addmember", str});
        e aVar = new a();
        try {
            aVar.groupId = str;
            this.nln = str;
            aVar.slB = i;
            this.nJW = i;
            aVar.slC = j;
            this.Anx = j;
            aVar.zML = strArr;
            aVar.slB = i;
            this.mYa = 3;
            this.zMg = com.tencent.wecall.talkroom.model.c.cHH().abW(str);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"NetSceneAddVoiceGroupMember constructor", e});
        }
        c(com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, aVar);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX;
    }

    protected final Object bC(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (x) e.a(new x(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cCD() {
        return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
    }
}
