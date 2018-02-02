package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.byl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.s;
import java.io.IOException;

public final class g extends b {
    private au fEJ;

    public g(au auVar) {
        this.fEJ = auVar;
    }

    protected final void send() {
        byl com_tencent_mm_protocal_c_byl = new byl();
        String str = this.fEJ.field_content;
        if (str != null) {
            a I = a.I(str, this.fEJ.field_reserved);
            if (I == null || !I.hcH.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                x.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
                return;
            }
            com_tencent_mm_protocal_c_byl.wYH = this.fEJ.field_msgId;
            com_tencent_mm_protocal_c_byl.wYG = this.fEJ.field_talker;
            str = this.fEJ.field_isSend == 1 ? I.hcB : I.hcA;
            com_tencent_mm_protocal_c_byl.fon = h.NM(this.fEJ.field_talker);
            if (s.eV(this.fEJ.field_talker)) {
                String d = b.d(this.fEJ.field_talker, this.fEJ);
                com_tencent_mm_protocal_c_byl.nje = String.format(ac.getContext().getString(R.l.eyQ), new Object[]{h.NM(d), Character.valueOf('​'), str});
            } else {
                com_tencent_mm_protocal_c_byl.nje = str;
            }
            try {
                com.tencent.mm.plugin.wear.model.a.bOt();
                r.a(20014, com_tencent_mm_protocal_c_byl.toByteArray(), true);
                com.tencent.mm.plugin.wear.model.c.a.ee(10, 0);
                com.tencent.mm.plugin.wear.model.c.a.zA(10);
                return;
            } catch (IOException e) {
                return;
            }
        }
        x.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
    }

    public final String getName() {
        return "WearLuckyCreateTask";
    }
}
