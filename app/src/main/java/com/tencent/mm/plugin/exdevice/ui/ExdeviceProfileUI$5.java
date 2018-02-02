package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.c;

class ExdeviceProfileUI$5 implements c {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$5(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final boolean azm() {
        View childAt = ExdeviceProfileUI.z(this.lVZ).getChildAt(ExdeviceProfileUI.z(this.lVZ).getChildCount() - 1);
        int count = ExdeviceProfileUI.z(this.lVZ).getAdapter().getCount();
        if (count <= 0 || childAt == null || childAt.getBottom() > ExdeviceProfileUI.z(this.lVZ).getHeight() || ExdeviceProfileUI.z(this.lVZ).getLastVisiblePosition() < count - 1) {
            return false;
        }
        return true;
    }
}
