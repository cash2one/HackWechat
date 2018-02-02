package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.wallet_core.ui.WalletTextView;

class b$a {
    TextView lkn;
    TextView llj;
    WalletTextView llk;
    TextView lll;

    public b$a(View view) {
        this.llj = (TextView) view.findViewById(f.uie);
        this.lll = (TextView) view.findViewById(f.uic);
        this.llk = (WalletTextView) view.findViewById(f.uij);
        this.lkn = (TextView) view.findViewById(f.uif);
    }
}
