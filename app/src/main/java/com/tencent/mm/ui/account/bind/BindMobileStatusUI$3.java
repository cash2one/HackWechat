package com.tencent.mm.ui.account.bind;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class BindMobileStatusUI$3 implements OnClickListener {
    final /* synthetic */ BindMobileStatusUI xTk;

    BindMobileStatusUI$3(BindMobileStatusUI bindMobileStatusUI) {
        this.xTk = bindMobileStatusUI;
    }

    public final void onClick(View view) {
        boolean z = true;
        BindMobileStatusUI.b(this.xTk, Boolean.valueOf(!BindMobileStatusUI.d(this.xTk).booleanValue()));
        if (BindMobileStatusUI.d(this.xTk).booleanValue()) {
            BindMobileStatusUI.e(this.xTk).setImageResource(R.k.dxO);
        } else {
            BindMobileStatusUI.e(this.xTk).setImageResource(R.k.dxP);
        }
        BindMobileStatusUI bindMobileStatusUI = this.xTk;
        if (BindMobileStatusUI.d(this.xTk).booleanValue()) {
            z = false;
        }
        BindMobileStatusUI.a(bindMobileStatusUI, z, 256, 7);
        if (!BindMobileStatusUI.d(this.xTk).booleanValue()) {
            BindMobileStatusUI.a(this.xTk, false, 2097152, 32);
        }
    }
}
