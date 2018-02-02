package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.sdk.platformtools.x;

public final class l {
    private static l syD;
    public aua syE;

    public static l bJn() {
        if (syD == null) {
            syD = new l();
        }
        return syD;
    }

    public final void a(aua com_tencent_mm_protocal_c_aua) {
        x.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s, real_time_balbance %s", Integer.valueOf(com_tencent_mm_protocal_c_aua.bME), Integer.valueOf(com_tencent_mm_protocal_c_aua.wBU), Integer.valueOf(com_tencent_mm_protocal_c_aua.wBT), Integer.valueOf(com_tencent_mm_protocal_c_aua.wBV));
        this.syE = com_tencent_mm_protocal_c_aua;
    }
}
