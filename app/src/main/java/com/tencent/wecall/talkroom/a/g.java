package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.d;

public final class g extends d {
    public String nln;

    public final int getType() {
        return c.CTRL_INDEX;
    }

    protected final Object bC(byte[] bArr) {
        com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[]{this.TAG2, "data2Resp"});
        if (bArr == null) {
            return null;
        }
        try {
            return (ac) e.a(new ac(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cCD() {
        return "CsCmd.Cmd_V_CSModifyVoiceGroupInfoReq";
    }
}
