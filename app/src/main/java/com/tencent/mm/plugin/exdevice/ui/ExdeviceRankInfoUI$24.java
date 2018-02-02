package com.tencent.mm.plugin.exdevice.ui;

import android.view.MotionEvent;
import com.tencent.mm.ui.base.MMPullDownView.a;

class ExdeviceRankInfoUI$24 implements a {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$24(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        ExdeviceRankInfoUI exdeviceRankInfoUI = this.lXj;
        if (ExdeviceRankInfoUI.a(this.lXj) == null || ExdeviceRankInfoUI.a(this.lXj).size() == 0) {
            z = false;
        } else {
            z = true;
        }
        ExdeviceRankInfoUI.b(exdeviceRankInfoUI, z);
        return false;
    }
}
