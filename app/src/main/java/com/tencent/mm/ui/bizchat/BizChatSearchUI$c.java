package com.tencent.mm.ui.bizchat;

import android.view.View;

class BizChatSearchUI$c {
    View kFQ;
    View kFR;
    View kFS;

    private BizChatSearchUI$c() {
    }

    final void q(boolean z, boolean z2) {
        int i;
        int i2 = 0;
        View view = this.kFQ;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        this.kFR.setVisibility(8);
        View view2 = this.kFS;
        if (!z2) {
            i2 = 8;
        }
        view2.setVisibility(i2);
    }
}
