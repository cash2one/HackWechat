package com.tencent.mm.plugin.wallet_index.ui;

import android.os.Bundle;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class OrderHandlerUI$1 extends c<sz> {
    final /* synthetic */ OrderHandlerUI taW;

    OrderHandlerUI$1(OrderHandlerUI orderHandlerUI) {
        this.taW = orderHandlerUI;
        this.xen = sz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sz szVar = (sz) bVar;
        if (szVar instanceof sz) {
            OrderHandlerUI.a(this.taW);
            x.e("MicroMsg.OrderHandlerUI", "onPayEnd, isOk = %s notifyPay %s", new Object[]{Integer.valueOf(szVar.fLs.result), Boolean.valueOf(OrderHandlerUI.b(this.taW))});
            if (!OrderHandlerUI.b(this.taW)) {
                if (bh.ov(szVar.fLs.fuH) || szVar.fLs.fuH.equals(OrderHandlerUI.c(this.taW))) {
                    if (szVar.fLs.result == -1) {
                        Bundle extras = szVar.fLs.intent.getExtras();
                        String string = extras.getString("intent_pay_app_url");
                        OrderHandlerUI.a(this.taW, extras.getString("intent_wap_pay_jump_url"));
                        x.d("MicroMsg.OrderHandlerUI", "onPayEnd, returnUrl = " + string);
                        OrderHandlerUI.d(this.taW).errCode = 0;
                        OrderHandlerUI.d(this.taW).returnKey = string;
                    } else {
                        OrderHandlerUI.d(this.taW).errCode = -2;
                    }
                    if (OrderHandlerUI.e(this.taW) == 1) {
                        OrderHandlerUI.aK(this.taW, OrderHandlerUI.f(this.taW));
                    } else {
                        e.a(this.taW, OrderHandlerUI.g(this.taW), OrderHandlerUI.d(this.taW), OrderHandlerUI.h(this.taW));
                    }
                    OrderHandlerUI.i(this.taW);
                    this.taW.finish();
                } else {
                    x.e("MicroMsg.OrderHandlerUI", "pass notify this req1 %s req2 %s", new Object[]{szVar.fLs.fuH, OrderHandlerUI.c(this.taW)});
                }
            }
        } else {
            x.f("MicroMsg.OrderHandlerUI", "mismatched event");
        }
        return false;
    }
}
