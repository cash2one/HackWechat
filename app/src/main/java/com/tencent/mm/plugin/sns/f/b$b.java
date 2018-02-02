package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.x;

class b$b {
    long hOu;
    StringBuffer qZL = new StringBuffer();
    String qZM;
    long qZN;
    long qZO;
    String qZP;
    String qZQ;

    public b$b(long j, String str, String str2, String str3, String str4) {
        this.qZM = str;
        this.qZP = str2;
        this.qZQ = str3;
        this.hOu = j;
        this.qZN = System.currentTimeMillis();
        this.qZL.append("1:0:" + str4);
    }

    public b$b(long j, String str, String str2, String str3) {
        this.qZM = str;
        this.qZP = str2;
        this.qZQ = str3;
        this.hOu = j;
        this.qZN = System.currentTimeMillis();
        this.qZL.append("0:0:");
    }

    public final void KN(String str) {
        x.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult " + str);
        if (this.qZL.length() != 0) {
            this.qZL.append("|");
        }
        this.qZL.append(str);
    }

    public final void wW() {
        this.qZO = System.currentTimeMillis();
        x.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.hOu + " uxinfo:" + this.qZM + " actionresult: " + this.qZL + " " + this.qZN + " " + this.qZO);
        g.pQN.h(11988, new Object[]{this.qZQ, this.qZP, "", "", i.eq(this.hOu), this.qZM, this.qZL, Long.valueOf(this.qZN / 1000), Long.valueOf(this.qZO / 1000)});
    }
}
