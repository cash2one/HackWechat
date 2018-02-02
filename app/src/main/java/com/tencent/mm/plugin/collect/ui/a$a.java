package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.wallet_core.ui.WalletTextView;

class a$a {
    TextView lkn;
    TextView llj;
    WalletTextView llk;

    public a$a(View view) {
        this.llj = (TextView) view.findViewById(f.uhU);
        this.llk = (WalletTextView) view.findViewById(f.uim);
        this.lkn = (TextView) view.findViewById(f.uhV);
    }
}
