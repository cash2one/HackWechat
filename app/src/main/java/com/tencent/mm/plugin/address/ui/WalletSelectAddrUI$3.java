package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class WalletSelectAddrUI$3 implements OnClickListener {
    final /* synthetic */ WalletSelectAddrUI iom;

    WalletSelectAddrUI$3(WalletSelectAddrUI walletSelectAddrUI) {
        this.iom = walletSelectAddrUI;
    }

    public final void onClick(View view) {
        h.a(this.iom, true, this.iom.getString(R.l.dDq, new Object[]{WalletSelectAddrUI.a(this.iom).toString()}), "", this.iom.getString(R.l.dDr), this.iom.getString(R.l.dEn), new 1(this), null);
    }
}
