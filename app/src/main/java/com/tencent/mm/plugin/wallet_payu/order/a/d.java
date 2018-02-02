package com.tencent.mm.plugin.wallet_payu.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderDetailUI;
import com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c;

public class d extends a {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.PayUShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
        c(activity, PayUMallOrderRecordListUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof PayUMallOrderRecordListUI) {
            c(activity, PayUMallOrderDetailUI.class, bundle);
        }
    }
}
