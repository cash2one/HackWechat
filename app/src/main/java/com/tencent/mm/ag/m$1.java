package com.tencent.mm.ag;

import com.tencent.mm.ag.m.a;
import com.tencent.mm.ag.m.b;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class m$1 implements Runnable {
    final /* synthetic */ String hpX;
    final /* synthetic */ String hpY;

    m$1(String str, String str2) {
        this.hpX = str;
        this.hpY = str2;
    }

    public final void run() {
        a Mn = y.Mn();
        String str = this.hpX;
        String str2 = this.hpY;
        if (bh.ov(str) || bh.ov(str2)) {
            x.e("MicroMsg.BrandLogic", "pushing for brand " + str + ", url " + str2);
        } else if (bh.by((long) bh.e((Integer) Mn.hqa.get(str))) < 300) {
            x.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for " + str);
        } else {
            Mn.hqa.put(str, Integer.valueOf((int) bh.Wo()));
            if (Mn.hqc == null || Mn.hqc.cfT()) {
                Mn.hqc = new as(1, "brand-logic");
            }
            Mn.hqc.c(new b(str, m.ag(str, str2)));
        }
    }
}
