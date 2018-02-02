package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j$a;
import com.tencent.mm.sdk.platformtools.x;

class SnsAdNativeLandingPagesUI$11 implements j$a {
    final /* synthetic */ SnsAdNativeLandingPagesUI ryv;
    final /* synthetic */ View ryz;

    SnsAdNativeLandingPagesUI$11(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI, View view) {
        this.ryv = snsAdNativeLandingPagesUI;
        this.ryz = view;
    }

    public final void bxi() {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "onDismiss");
        bAt();
    }

    public final void bxj() {
        x.i("MicroMsg.SnsAdNativeLandingPagesUI", "onCancel");
        bAt();
    }

    private void bAt() {
        if (!(this.ryz == null || this.ryz.getParent() == null)) {
            ((ViewGroup) this.ryz.getParent()).removeView(this.ryz);
        }
        SnsAdNativeLandingPagesUI.aa(this.ryv);
    }
}
