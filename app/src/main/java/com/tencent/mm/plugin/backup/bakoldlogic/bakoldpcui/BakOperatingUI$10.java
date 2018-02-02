package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMWizardActivity;

class BakOperatingUI$10 implements Runnable {
    final /* synthetic */ BakOperatingUI krW;

    BakOperatingUI$10(BakOperatingUI bakOperatingUI) {
        this.krW = bakOperatingUI;
    }

    public final void run() {
        if (6 == BakOperatingUI.j(this.krW)) {
            BakOperatingUI.m(this.krW).post(new Runnable(this) {
                final /* synthetic */ BakOperatingUI$10 krX;

                {
                    this.krX = r1;
                }

                public final void run() {
                    this.krX.krW.showOptionMenu(false);
                    if (BakOperatingUI.h(this.krX.krW) != null) {
                        BakOperatingUI.h(this.krX.krW).setProgress(0);
                    }
                    if (BakOperatingUI.k(this.krX.krW) != null) {
                        BakOperatingUI.k(this.krX.krW).setText(this.krX.krW.getString(R.l.dKh));
                    }
                    if (BakOperatingUI.l(this.krX.krW) != null) {
                        BakOperatingUI.l(this.krX.krW).setText(this.krX.krW.getString(R.l.dKg));
                    }
                    if (BakOperatingUI.i(this.krX.krW) != null) {
                        BakOperatingUI.i(this.krX.krW).setText(this.krX.krW.getString(R.l.dJZ) + "0%");
                    }
                }
            });
        } else if (1 == BakOperatingUI.j(this.krW)) {
            Intent intent = new Intent(this.krW, BakFinishUI.class);
            intent.putExtra("cmd", BakOperatingUI.j(this.krW));
            MMWizardActivity.A(this.krW, intent);
        }
    }
}
