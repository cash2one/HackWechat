package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.bzn;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l extends c {
    private String talker;
    private int tip;

    public l(int i, String str) {
        this.tip = i;
        this.talker = str;
    }

    public final String getName() {
        return "WearVoipControllerTask";
    }

    protected final void send() {
        switch (this.tip) {
            case 20010:
                bzn com_tencent_mm_protocal_c_bzn = new bzn();
                com_tencent_mm_protocal_c_bzn.wYG = this.talker;
                com_tencent_mm_protocal_c_bzn.kub = h.NM(this.talker);
                try {
                    a.bOt();
                    r.a(this.tip, com_tencent_mm_protocal_c_bzn.toByteArray(), false);
                    return;
                } catch (IOException e) {
                    return;
                }
            case 20011:
            case 20012:
                try {
                    a.bOt();
                    r.a(this.tip, this.talker.getBytes("utf8"), false);
                    return;
                } catch (UnsupportedEncodingException e2) {
                    return;
                }
            default:
                return;
        }
    }
}
