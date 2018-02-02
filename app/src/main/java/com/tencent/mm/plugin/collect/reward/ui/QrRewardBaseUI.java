package com.tencent.mm.plugin.collect.reward.ui;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class QrRewardBaseUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ayW();
        setBackBtn(new 1(this), h.dvO);
    }

    protected void ayW() {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.uaz)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(a$f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(c.transparent));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(c.black));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(c.uaB));
            window.setNavigationBarColor(getResources().getColor(c.uaA));
        }
    }
}
