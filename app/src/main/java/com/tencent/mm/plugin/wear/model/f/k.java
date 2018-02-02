package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.byy;
import java.io.IOException;

public final class k extends c {
    private int code;
    private String fpb;

    public k(int i, String str) {
        this.code = i;
        this.fpb = str;
    }

    protected final void send() {
        byy com_tencent_mm_protocal_c_byy = new byy();
        switch (this.code) {
            case 0:
                com_tencent_mm_protocal_c_byy.wPs = 0;
                break;
            case 6:
                com_tencent_mm_protocal_c_byy.wPs = 196610;
                break;
            case 7:
                com_tencent_mm_protocal_c_byy.wPs = 196615;
                break;
            case 8:
                com_tencent_mm_protocal_c_byy.wPs = 196614;
                break;
            case 9:
                com_tencent_mm_protocal_c_byy.wPs = 196613;
                break;
        }
        com_tencent_mm_protocal_c_byy.wXG = this.fpb;
        try {
            a.bOt();
            r.a(20016, com_tencent_mm_protocal_c_byy.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearPushPayResponseTask";
    }
}
