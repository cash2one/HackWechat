package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.sport.ui.SportChartView;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class ExdeviceProfileUI$22 implements a {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$22(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final void cw(boolean z) {
        if (ExdeviceProfileUI.F(this.lVZ) != null) {
            if (z) {
                ExdeviceProfileUI.G(this.lVZ).ye(SportChartView.a.rUO);
            } else {
                ExdeviceProfileUI.G(this.lVZ).ye(SportChartView.a.rUN);
            }
        }
        ExdeviceProfileUI.G(this.lVZ).cc(ExdeviceProfileUI.F(this.lVZ));
    }
}
