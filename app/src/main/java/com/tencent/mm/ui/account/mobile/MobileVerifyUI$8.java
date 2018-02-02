package com.tencent.mm.ui.account.mobile;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.tools.l;

class MobileVerifyUI$8 implements OnClickListener {
    final /* synthetic */ MobileVerifyUI xVi;
    private final int xVk = 0;
    private final int xVl = 1;
    private final int xVm = 2;

    MobileVerifyUI$8(MobileVerifyUI mobileVerifyUI) {
        this.xVi = mobileVerifyUI;
    }

    public final void onClick(View view) {
        l lVar = new l(this.xVi);
        lVar.rKC = new 1(this);
        lVar.rKD = new 2(this);
        lVar.bBX();
    }
}
