package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public enum b {
    ;
    
    private Map<String, WeakReference<a>> sRb;

    private b(String str) {
        this.sRb = new HashMap();
    }

    public final a a(Orders orders) {
        String str;
        if (orders == null || orders.sNW == null) {
            str = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < orders.sNW.size(); i++) {
                stringBuilder.append(((Commodity) orders.sNW.get(i)).fuI);
            }
            stringBuilder.append("@");
            stringBuilder.append(orders.sNE);
            str = stringBuilder.toString();
        }
        if (bh.ov(str)) {
            x.w("MicroMsg.FavorLogicHelperPool", "get key null");
            return null;
        }
        if (this.sRb.containsKey(str)) {
            x.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:" + str);
            WeakReference weakReference = (WeakReference) this.sRb.get(str);
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    return aVar;
                }
                x.i("MicroMsg.FavorLogicHelperPool", "helper null");
            } else {
                x.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
            }
        }
        if (orders == null || orders.sNX == null) {
            return null;
        }
        a aVar2 = new a(orders.sNX);
        this.sRb.put(str, new WeakReference(aVar2));
        return aVar2;
    }
}
