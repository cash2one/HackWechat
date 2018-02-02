package com.tencent.mm.ui.account.mobile;

import com.tencent.mm.R;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.1;

class MobileVerifyUI$1$1 implements Runnable {
    final /* synthetic */ 1 xVj;

    MobileVerifyUI$1$1(1 1) {
        this.xVj = 1;
    }

    public final void run() {
        this.xVj.xVi.xUX = this.xVj.xVi.xUX - 1;
        if (this.xVj.xVi.xUX >= 0) {
            this.xVj.xVi.xUT.setText(this.xVj.xVi.getResources().getQuantityString(R.j.duC, (int) this.xVj.xVi.xUX, new Object[]{Integer.valueOf((int) this.xVj.xVi.xUX)}));
            return;
        }
        this.xVj.xVi.xUT.setVisibility(8);
        this.xVj.xVi.xUS.setVisibility(0);
        MobileVerifyUI.d(this.xVj.xVi);
        this.xVj.xVi.xUS.setEnabled(true);
        this.xVj.xVi.xUS.setText(this.xVj.xVi.getString(R.l.evs));
    }
}
