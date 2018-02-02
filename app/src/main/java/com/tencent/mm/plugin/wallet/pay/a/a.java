package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.d;
import com.tencent.mm.plugin.wallet.pay.a.a.e;
import com.tencent.mm.plugin.wallet.pay.a.a.f;
import com.tencent.mm.plugin.wallet.pay.a.a.g;
import com.tencent.mm.plugin.wallet.pay.a.a.h;
import com.tencent.mm.plugin.wallet.pay.a.d.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static b a(Authen authen, Orders orders, boolean z) {
        if (authen == null || orders == null) {
            x.i("MicroMsg.CgiManager", "empty authen or orders");
            return null;
        }
        PayInfo payInfo = authen.pCn;
        String str = "";
        if (payInfo != null) {
            x.i("MicroMsg.CgiManager", "get reqKey from payInfo");
            str = payInfo.fuH;
        }
        if (bh.ov(str) && orders != null) {
            x.i("MicroMsg.CgiManager", "get reqKey from orders");
            str = orders.fuH;
        }
        if (bh.ov(str)) {
            x.i("MicroMsg.CgiManager", "empty reqKey!");
            return new b(authen, orders, z);
        }
        x.i("MicroMsg.CgiManager", "authen reqKey: %s", new Object[]{str});
        if (!(payInfo == null || orders == null)) {
            x.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[]{payInfo.fuH, orders.fuH});
        }
        x.i("MicroMsg.CgiManager", "authen go new split cgi");
        if (str.startsWith("sns_aa_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.a.a(authen, orders, z);
        }
        if (str.startsWith("sns_tf_")) {
            return new h(authen, orders, z);
        }
        if (str.startsWith("sns_ff_")) {
            return new d(authen, orders, z);
        }
        if (str.startsWith("ts_")) {
            return new e(authen, orders, z);
        }
        if (str.startsWith("sns_")) {
            return new g(authen, orders, z);
        }
        if (str.startsWith("offline_")) {
            return new f(authen, orders, z);
        }
        return new b(authen, orders, z);
    }

    public static com.tencent.mm.plugin.wallet.pay.a.d.e a(p pVar, Orders orders) {
        if (pVar == null || orders == null) {
            x.e("MicroMsg.CgiManager", "empty verify or orders");
            return null;
        }
        PayInfo payInfo = pVar.pCn;
        String str = "";
        if (payInfo != null) {
            x.i("MicroMsg.CgiManager", "get reqKey from payInfo");
            str = payInfo.fuH;
        }
        if (bh.ov(str)) {
            x.i("MicroMsg.CgiManager", "get reqKey from orders");
            str = orders.fuH;
        }
        if (bh.ov(str)) {
            x.i("MicroMsg.CgiManager", "empty reqKey!");
            return new com.tencent.mm.plugin.wallet.pay.a.d.e(pVar, orders);
        }
        if (payInfo != null) {
            x.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[]{payInfo.fuH, orders.fuH});
        }
        x.i("MicroMsg.CgiManager", "verify reqKey: %s", new Object[]{str});
        x.i("MicroMsg.CgiManager", "verify go new split cgi");
        if (str.startsWith("sns_aa_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.d.a(pVar, orders);
        }
        if (str.startsWith("sns_tf_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.d.g(pVar, orders);
        }
        if (str.startsWith("sns_ff_")) {
            return new c(pVar, orders);
        }
        if (str.startsWith("ts_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.d.d(pVar, orders);
        }
        if (str.startsWith("sns_")) {
            return new com.tencent.mm.plugin.wallet.pay.a.d.f(pVar, orders);
        }
        return new com.tencent.mm.plugin.wallet.pay.a.d.e(pVar, orders);
    }
}
