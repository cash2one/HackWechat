package com.tencent.mm.ui.account.bind;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

class BindMobileStatusUI$2 implements OnClickListener {
    final /* synthetic */ BindMobileStatusUI xTk;

    BindMobileStatusUI$2(BindMobileStatusUI bindMobileStatusUI) {
        this.xTk = bindMobileStatusUI;
    }

    public final void onClick(View view) {
        boolean z = true;
        BindMobileStatusUI.a(this.xTk, Boolean.valueOf(!BindMobileStatusUI.b(this.xTk).booleanValue()));
        if (BindMobileStatusUI.b(this.xTk).booleanValue()) {
            BindMobileStatusUI.c(this.xTk).setImageResource(R.k.dxO);
        } else {
            BindMobileStatusUI.c(this.xTk).setImageResource(R.k.dxP);
        }
        BindMobileStatusUI bindMobileStatusUI = this.xTk;
        if (BindMobileStatusUI.b(this.xTk).booleanValue()) {
            z = false;
        }
        BindMobileStatusUI.a(bindMobileStatusUI, z, WXMediaMessage.TITLE_LENGTH_LIMIT, 8);
    }
}
