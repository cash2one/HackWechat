package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class WalletRealNameVerifyUI$6 implements OnClickListener {
    final /* synthetic */ WalletRealNameVerifyUI sJO;

    WalletRealNameVerifyUI$6(WalletRealNameVerifyUI walletRealNameVerifyUI) {
        this.sJO = walletRealNameVerifyUI;
    }

    public final void onClick(View view) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(this.sJO.getString(a$i.uPW));
        linkedList2.add(Integer.valueOf(0));
        if (WalletRealNameVerifyUI.e(this.sJO) != null && WalletRealNameVerifyUI.e(this.sJO).sMR) {
            linkedList.add(this.sJO.getString(a$i.uPV));
            linkedList2.add(Integer.valueOf(1));
        }
        h.a(this.sJO, "", linkedList, linkedList2, "", new 1(this));
    }
}
