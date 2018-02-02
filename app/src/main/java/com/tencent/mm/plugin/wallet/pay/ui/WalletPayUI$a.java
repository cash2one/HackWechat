package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

protected class WalletPayUI$a {
    final /* synthetic */ WalletPayUI sGh;

    protected WalletPayUI$a(WalletPayUI walletPayUI) {
        this.sGh = walletPayUI;
    }

    public final void notifyDataSetChanged() {
        this.sGh.sFQ.removeAllViews();
        int i = this.sGh.mCount == 0 ? 0 : this.sGh.sFE ? this.sGh.mCount : 1;
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        for (int i2 = 0; i2 < i; i2++) {
            View inflate = ((LayoutInflater) this.sGh.getSystemService("layout_inflater")).inflate(g.uFB, null);
            TextView textView = (TextView) inflate.findViewById(a$f.uzl);
            TextView textView2 = (TextView) inflate.findViewById(a$f.uzD);
            Commodity commodity = (Commodity) this.sGh.pPl.sNW.get(i2);
            Object obj = "";
            if (this.sGh.sEO != null && (this.sGh.sEO.fCV == 32 || this.sGh.sEO.fCV == 33 || this.sGh.sEO.fCV == 31 || this.sGh.sEO.fCV == 48)) {
                String string = this.sGh.sEO.vzx.getString("extinfo_key_1", "");
                if (bh.ov(string)) {
                    x.e("MicroMsg.WalletPayUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                } else {
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.storage.x WM = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WM(string);
                    if (WM != null) {
                        obj = WM.AQ();
                    } else {
                        x.e("MicroMsg.WalletPayUI", "can not found contact for user::" + string);
                    }
                }
            }
            if (commodity != null) {
                if (!bh.ov(obj)) {
                    textView2.setText(obj);
                    textView2.setVisibility(0);
                    ((TextView) inflate.findViewById(a$f.uzE)).setVisibility(0);
                } else if (bh.ov(commodity.pao)) {
                    ((TextView) inflate.findViewById(a$f.uzE)).setVisibility(8);
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(commodity.pao);
                    textView2.setVisibility(0);
                    ((TextView) inflate.findViewById(a$f.uzE)).setVisibility(0);
                }
                if (bh.ov(commodity.desc)) {
                    ((TextView) inflate.findViewById(a$f.uzn)).setVisibility(8);
                    textView.setVisibility(8);
                } else {
                    textView.setText(commodity.desc);
                    textView.setVisibility(8);
                    ((TextView) inflate.findViewById(a$f.uzn)).setVisibility(8);
                }
                if (bh.ov(obj) && bh.ov(commodity.pao)) {
                    inflate.setVisibility(8);
                } else {
                    inflate.setVisibility(0);
                }
            }
            inflate.setLayoutParams(layoutParams);
            inflate.measure(-2, -2);
            this.sGh.sFQ.addView(inflate);
        }
    }
}
