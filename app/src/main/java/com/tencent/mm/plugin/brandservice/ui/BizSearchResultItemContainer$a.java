package com.tencent.mm.plugin.brandservice.ui;

import android.view.View;

class BizSearchResultItemContainer$a {
    View kFQ;
    View kFR;
    View kFS;

    private BizSearchResultItemContainer$a() {
    }

    public final void nx(int i) {
        switch (i) {
            case 1:
                q(true, false);
                return;
            case 2:
                q(false, true);
                return;
            case 3:
                q(false, false);
                return;
            default:
                q(false, false);
                return;
        }
    }

    private void q(boolean z, boolean z2) {
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
