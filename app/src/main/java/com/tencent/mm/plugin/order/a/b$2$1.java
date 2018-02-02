package com.tencent.mm.plugin.order.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.a.b.2;
import com.tencent.mm.plugin.order.model.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class b$2$1 implements Runnable {
    final /* synthetic */ String iGf;
    final /* synthetic */ 2 oZT;

    b$2$1(2 2, String str) {
        this.oZT = 2;
        this.iGf = str;
    }

    public final void run() {
        b bVar = this.oZT.oZS;
        g.Dh().Ct();
        if (bVar.oZO == null) {
            bVar.oZO = new b();
        }
        b bVar2 = bVar.oZO;
        String str = this.iGf;
        if (!bh.ov(str)) {
            Map y = bi.y(str, "sysmsg");
            if (y != null) {
                try {
                    str = (String) y.get(".sysmsg.wxpay.transid");
                    if (!bh.ov(str)) {
                        x.d("MicroMsg.WalletOrdersManager", "transid " + str);
                        if (!bVar2.pai.contains(str)) {
                            bVar2.pai.add(str);
                            g.Dk();
                            g.Dj().CU().set(204817, Integer.valueOf(bVar2.pai.size()));
                            x.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + bVar2.pai.size());
                            bVar2.bix();
                            b.bit().asi();
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.WalletOrdersManager", "cmdid error");
                }
            }
        }
    }
}
