package com.tencent.mm.ui.account.mobile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;

class MobileInputUI$16 implements OnClickListener {
    final /* synthetic */ MobileInputUI xUi;

    MobileInputUI$16(MobileInputUI mobileInputUI) {
        this.xUi = mobileInputUI;
    }

    public final void onClick(View view) {
        MobileInputUI.ay(this.xUi, this.xUi.getString(R.l.eke, new Object[]{w.cfi()}));
    }
}
