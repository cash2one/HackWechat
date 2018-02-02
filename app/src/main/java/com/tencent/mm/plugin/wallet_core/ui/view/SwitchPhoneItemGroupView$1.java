package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a$h;

class SwitchPhoneItemGroupView$1 implements OnClickListener {
    final /* synthetic */ SwitchPhoneItemGroupView sXu;

    SwitchPhoneItemGroupView$1(SwitchPhoneItemGroupView switchPhoneItemGroupView) {
        this.sXu = switchPhoneItemGroupView;
    }

    public final void onClick(View view) {
        for (SwitchPhoneItemView switchPhoneItemView : this.sXu.sXr) {
            switchPhoneItemView.sXx.setImageResource(a$h.dAq);
        }
        ((SwitchPhoneItemView) view).sXx.setImageResource(a$h.dAr);
        if (SwitchPhoneItemGroupView.a(this.sXu) != null) {
            SwitchPhoneItemGroupView.a(this.sXu).cT(view);
        }
    }
}
