package com.tencent.mm.plugin.order.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI;
import com.tencent.mm.plugin.order.ui.MallOrderProductListUI;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c;

public class a extends c {
    public c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.ShowOrdersInfoProcess", "start Process : ShowOrdersInfo");
        c(activity, MallOrderRecordListUI.class, bundle);
        return this;
    }

    public void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof MallOrderRecordListUI) {
            c(activity, MallOrderTransactionInfoUI.class, bundle);
        } else if (activity instanceof MallOrderDetailInfoUI) {
            int i2 = bundle.getInt("key_enter_id");
            if (i2 == 0) {
                c(activity, MallOrderProductListUI.class, bundle);
            } else if (i2 == 1) {
                c(activity, MallOrderTransactionInfoUI.class, bundle);
            }
        } else if ((activity instanceof MallOrderProductListUI) || (activity instanceof MallOrderTransactionInfoUI)) {
            C(activity);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        super.ah(activity);
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aKG() {
        return "ShowOrdersInfoProcess";
    }
}
