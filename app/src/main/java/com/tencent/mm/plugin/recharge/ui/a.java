package com.tencent.mm.plugin.recharge.ui;

import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class a {
    public static MallRechargeProduct bu(List<MallRechargeProduct> list) {
        for (MallRechargeProduct mallRechargeProduct : list) {
            if (mallRechargeProduct.isDefault && mallRechargeProduct.isValid()) {
                x.d("MicroMsg.MallRechargeLogic", "find the defaultProduct");
                return mallRechargeProduct;
            }
        }
        x.d("MicroMsg.MallRechargeLogic", "products.get(0)");
        return (MallRechargeProduct) list.get(0);
    }
}
