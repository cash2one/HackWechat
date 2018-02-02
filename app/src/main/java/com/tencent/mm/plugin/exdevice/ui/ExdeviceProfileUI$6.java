package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.d;

class ExdeviceProfileUI$6 implements d {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$6(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final boolean azl() {
        if (ExdeviceProfileUI.z(this.lVZ).getFirstVisiblePosition() == 0) {
            View childAt = ExdeviceProfileUI.z(this.lVZ).getChildAt(ExdeviceProfileUI.z(this.lVZ).getFirstVisiblePosition());
            if (childAt != null && childAt.getTop() >= 0) {
                return true;
            }
        }
        return false;
    }
}
