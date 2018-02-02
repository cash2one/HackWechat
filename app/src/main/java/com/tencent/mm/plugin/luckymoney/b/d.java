package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    c obJ;

    public d() {
        init();
    }

    private void init() {
        this.obJ = new c();
        g.Dk();
        String str = (String) g.Dj().CU().get(356355, null);
        if (bh.ov(str)) {
            this.obJ.obA = 2000.0d;
            this.obJ.obz = 100;
            this.obJ.obE = 200.0d;
            this.obJ.obF = 0.01d;
            this.obJ.obD = 200.0d;
        } else {
            try {
                this.obJ.aF(str.getBytes("ISO-8859-1"));
            } catch (Exception e) {
                x.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
                this.obJ.obA = 2000.0d;
                this.obJ.obz = 100;
                this.obJ.obE = 200.0d;
                this.obJ.obF = 0.01d;
                this.obJ.obD = 200.0d;
            }
        }
        x.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.obJ.obA + " maxTotalNum:" + this.obJ.obz + " perGroupMaxValue:" + this.obJ.obE + " perMinValue:" + this.obJ.obF + " perPersonMaxValue:" + this.obJ.obD);
    }

    public final c aXb() {
        if (this.obJ == null) {
            init();
        }
        return this.obJ;
    }
}
