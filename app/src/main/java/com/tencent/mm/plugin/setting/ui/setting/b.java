package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;

final class b {
    LinearLayout qmF;
    LinearLayout qmG;
    LinearLayout qmH;
    LinearLayout qmI;
    LinearLayout qmJ;

    b() {
    }

    public final void Jd(String str) {
        if (str.equals("downloading")) {
            this.qmF.setVisibility(0);
            this.qmG.setVisibility(8);
            this.qmH.setVisibility(8);
            this.qmI.setVisibility(8);
            this.qmJ.setVisibility(8);
        } else if (str.equals("downloaded")) {
            this.qmF.setVisibility(8);
            this.qmG.setVisibility(0);
            this.qmH.setVisibility(8);
            this.qmI.setVisibility(8);
            this.qmJ.setVisibility(8);
        } else if (str.equals("undownloaded")) {
            this.qmF.setVisibility(8);
            this.qmG.setVisibility(8);
            this.qmH.setVisibility(0);
            this.qmI.setVisibility(8);
            this.qmJ.setVisibility(8);
        } else if (str.equals("using")) {
            this.qmF.setVisibility(8);
            this.qmG.setVisibility(8);
            this.qmH.setVisibility(8);
            this.qmI.setVisibility(0);
            this.qmJ.setVisibility(8);
        } else if (str.equals("canceling")) {
            this.qmF.setVisibility(8);
            this.qmG.setVisibility(8);
            this.qmH.setVisibility(8);
            this.qmI.setVisibility(8);
            this.qmJ.setVisibility(0);
        }
    }
}
