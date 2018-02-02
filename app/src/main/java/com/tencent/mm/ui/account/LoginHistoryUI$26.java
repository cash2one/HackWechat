package com.tencent.mm.ui.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.o;
import java.util.List;

class LoginHistoryUI$26 implements OnClickListener {
    final /* synthetic */ List lnl;
    final /* synthetic */ LoginHistoryUI xPa;

    LoginHistoryUI$26(LoginHistoryUI loginHistoryUI, List list) {
        this.xPa = loginHistoryUI;
        this.lnl = list;
    }

    public final void onClick(View view) {
        LoginHistoryUI.a(this.xPa, ((o) this.lnl.get(0)).getItemId());
    }
}
