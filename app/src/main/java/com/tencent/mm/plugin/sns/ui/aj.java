package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class aj {
    String maQ = "";
    int position = 0;
    long qXh = 0;
    int rwA = 0;
    long rwy = 0;
    String rwz = "";

    public final boolean bAa() {
        x.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[]{Long.valueOf(bh.bA(this.rwy))});
        x.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", new Object[]{Long.valueOf(this.rwy), this.maQ, this.rwz, Long.valueOf(this.qXh), Integer.valueOf(this.position), Integer.valueOf(this.rwA)});
        if (bh.bA(this.rwy) >= 180000 || this.position <= 0) {
            return false;
        }
        x.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[]{Long.valueOf(this.qXh)});
        if (this.qXh == 0) {
            return false;
        }
        ae.bvl().x(this.qXh, -1);
        return true;
    }
}
