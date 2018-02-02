package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.snackbar.b$b;

class SnsAdNativeLandingPagesUI$6 implements b$b {
    final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

    SnsAdNativeLandingPagesUI$6(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.ryv = snsAdNativeLandingPagesUI;
    }

    public final void aPO() {
        try {
            AdLandingPagesProxy.getInstance().favEditTag();
        } catch (Exception e) {
            x.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + e.getMessage());
        }
    }
}
