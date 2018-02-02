package com.tencent.mm.wallet_core.ui.formview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.u;

class a$6 implements OnClickListener {
    final /* synthetic */ MMActivity lOS;
    final /* synthetic */ WalletFormView zJs;

    a$6(WalletFormView walletFormView, MMActivity mMActivity) {
        this.zJs = walletFormView;
        this.lOS = mMActivity;
    }

    public final void onClick(View view) {
        this.zJs.getContext();
        b.a(this.lOS, u.cBG(), i.uIU);
    }
}
