package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.18;
import com.tencent.mm.ui.base.p.d;

class SnsAdNativeLandingPagesUI$18$3 implements d {
    final /* synthetic */ 18 ryE;

    SnsAdNativeLandingPagesUI$18$3(18 18) {
        this.ryE = 18;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        SnsAdNativeLandingPagesUI.b(this.ryE.ryv);
        if (menuItem != null) {
            switch (menuItem.getItemId()) {
                case 1:
                    SnsAdNativeLandingPagesUI.w(this.ryE.ryv);
                    return;
                case 2:
                    SnsAdNativeLandingPagesUI.x(this.ryE.ryv);
                    return;
                case 3:
                    SnsAdNativeLandingPagesUI.y(this.ryE.ryv);
                    return;
                case 4:
                    this.ryE.ryv.s(this.ryE.ryv, SnsAdNativeLandingPagesUI.o(this.ryE.ryv), SnsAdNativeLandingPagesUI.p(this.ryE.ryv));
                    return;
                default:
                    return;
            }
        }
    }
}
