package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFlipper.a;

class SelectScanModePanel$1 implements a {
    final /* synthetic */ SelectScanModePanel pZm;

    SelectScanModePanel$1(SelectScanModePanel selectScanModePanel) {
        this.pZm = selectScanModePanel;
    }

    public final void dm(int i, int i2) {
        x.v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + SelectScanModePanel.a(this.pZm));
        if (!SelectScanModePanel.a(this.pZm) && i2 != 0 && i != 0) {
            SelectScanModePanel.b(this.pZm);
            SelectScanModePanel.a(this.pZm, i2);
            SelectScanModePanel.b(this.pZm, i);
            SelectScanModePanel.c(this.pZm);
        }
    }
}
