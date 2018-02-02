package com.tencent.mm.plugin.wxpay;

import com.tencent.mm.bm.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.aa.b;
import com.tencent.mm.plugin.mall.a.d;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.z.p;

public class PluginWxPay extends f implements a {
    public String name() {
        return "plugin-wxpay";
    }

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
    }

    public void configure(g gVar) {
        if (gVar.DS()) {
            pin(new p(b.class));
            pin(new p(com.tencent.mm.plugin.collect.a.a.class));
            pin(new p(com.tencent.mm.plugin.luckymoney.a.a.class));
            pin(new p(d.class));
            pin(new p(k.class));
            pin(new p(com.tencent.mm.plugin.order.a.b.class));
            pin(new p(com.tencent.mm.plugin.product.a.a.class));
            pin(new p(com.tencent.mm.plugin.recharge.a.a.class));
            pin(new p(com.tencent.mm.plugin.remittance.a.b.class));
            pin(new p(com.tencent.mm.plugin.wallet.a.p.class));
            pin(new p(o.class));
            pin(new p(com.tencent.mm.plugin.wallet_index.a.a.class));
            pin(new p(com.tencent.mm.plugin.wallet_payu.a.d.class));
            pin(new p(com.tencent.mm.plugin.wxcredit.a.class));
            pin(new p(com.tencent.mm.plugin.fingerprint.a.class));
            pin(new p(com.tencent.mm.plugin.wallet_ecard.a.class));
        }
    }

    public void execute(g gVar) {
        if (gVar.DS()) {
            c.Tb("wallet");
            c.Tb("mall");
            c.Tb("wxcredit");
            c.Tb("offline");
            c.Tb("recharge");
            c.Tb("wallet_index");
            c.Tb("order");
            c.Tb("product");
            c.Tb("remittance");
            c.Tb("collect");
            c.Tb("wallet_payu");
            c.Tb("luckymoney");
            c.Tb("fingerprint");
        }
    }
}
