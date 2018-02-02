package com.tencent.mm.plugin.recharge.ui;

import android.widget.AutoCompleteTextView;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$12 implements a {
    final /* synthetic */ PhoneRechargeUI pDm;

    PhoneRechargeUI$12(PhoneRechargeUI phoneRechargeUI) {
        this.pDm = phoneRechargeUI;
    }

    public final void hx(boolean z) {
        if (z) {
            this.pDm.aWs();
            final String Id = b.Id(PhoneRechargeUI.a(this.pDm).getText());
            if (Id == null) {
                x.e("MicroMsg.PhoneRechargeUI", "null phone, return");
                return;
            }
            e.a(new Runnable(this) {
                final /* synthetic */ PhoneRechargeUI$12 pDq;

                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.mm.plugin.recharge.model.a a = PhoneRechargeUI.a(this.pDq.pDm, Id);
                    x.d("MicroMsg.PhoneRechargeUI", "handle cost: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    ag.y(new 1(this, a));
                }
            }, "search_matched_mobile");
            if (PhoneRechargeUI.c(this.pDm)) {
                PhoneRechargeUI.a(this.pDm, false);
                return;
            }
            x.d("MicroMsg.PhoneRechargeUI", "clear focus");
            PhoneRechargeUI.a(this.pDm, true);
            return;
        }
        PhoneRechargeUI.a(this.pDm).pEj.setText("");
        PhoneRechargeUI.a(this.pDm).pEj.setTextColor(this.pDm.getResources().getColor(c.btv));
        PhoneRechargeUI.d(this.pDm);
        PhoneRechargeUI.e(this.pDm);
        if (bh.ov(PhoneRechargeUI.a(this.pDm).getText())) {
            ((AutoCompleteTextView) PhoneRechargeUI.a(this.pDm).pEh).showDropDown();
        }
    }
}
