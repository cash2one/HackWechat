package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static Orders a(Orders orders, String str, String str2, int i, String str3) {
        if (orders == null || orders.sNW == null || orders.sNW.size() <= 0) {
            x.d("MicroMsg.OrdersWrapper", "hy: params error");
        } else {
            for (Commodity commodity : orders.sNW) {
                commodity.pav = i;
                commodity.pas = str.equals("1") ? "2" : "1";
                commodity.pat = str2;
                commodity.pax = str3;
            }
        }
        return orders;
    }
}
