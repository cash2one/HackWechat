package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.pb.common.b.a.a.ai;
import com.tencent.pb.common.b.d;

public final class j extends d {
    public String nln;

    public final int getType() {
        return c.CTRL_INDEX;
    }

    protected final Object bC(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (ai) e.a(new ai(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m(this.TAG2, new Object[]{"data2Resp", e});
            return null;
        }
    }

    protected final String cCD() {
        return "CsCmd.Cmd_V_CSVoiceMemberWhisperReq";
    }
}
