package com.tencent.mm.plugin.order.model;

import android.content.Context;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.order.ui.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;

public final class a {
    public static e a(Context context, MallTransactionObject mallTransactionObject) {
        e eVar = new e(context);
        if (bh.ov(mallTransactionObject.paJ)) {
            eVar.pcP = context.getString(i.uTN);
        } else {
            eVar.pcP = context.getString(i.uTK);
        }
        eVar.mOnClickListener = new 1(mallTransactionObject, context);
        return eVar;
    }

    public static void a(int i, Context context, MallTransactionObject mallTransactionObject) {
        switch (i) {
            case 0:
                g.Dk();
                af WO = ((h) g.h(h.class)).EY().WO(mallTransactionObject.paA);
                if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type)) {
                    com.tencent.mm.wallet_core.ui.e.S(context, mallTransactionObject.paA);
                    return;
                } else {
                    com.tencent.mm.wallet_core.ui.e.bx(context, mallTransactionObject.paA);
                    return;
                }
            case 1:
                com.tencent.mm.wallet_core.ui.e.by(context, mallTransactionObject.pac);
                return;
            case 2:
                com.tencent.mm.wallet_core.ui.e.l(context, mallTransactionObject.paJ, false);
                return;
            default:
                return;
        }
    }
}
