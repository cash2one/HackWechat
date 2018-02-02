package com.tencent.mm.plugin.sns.ui;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;

class SnsAdNativeLandingPagesUI$13 extends h {
    final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

    SnsAdNativeLandingPagesUI$13(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.ryv = snsAdNativeLandingPagesUI;
    }

    public final void a(int i, float f, int i2) {
        super.a(i, f, i2);
        b e = SnsAdNativeLandingPagesUI.e(this.ryv);
        if (e.rmS != null) {
            e.rmS.bxy();
        }
        if (this.ryv.mController.xJg == 1) {
            this.ryv.aWs();
        }
    }

    public final void af(int i) {
        super.af(i);
        SnsAdNativeLandingPagesUI.e(this.ryv).rmY = i;
        Fragment fragment;
        if (i == 1) {
            for (int i2 = 0; i2 < this.ryv.rxB.size(); i2++) {
                fragment = (Fragment) SnsAdNativeLandingPagesUI.f(this.ryv).get(Integer.valueOf(((c) this.ryv.rxB.get(i2)).id));
                if (fragment != null) {
                    ((b) fragment).bxI();
                }
            }
            ac.dw(this.ryv.mController.xIM);
        } else if (i == 0) {
            fragment = (Fragment) SnsAdNativeLandingPagesUI.f(this.ryv).get(Integer.valueOf(((c) this.ryv.rxB.get(SnsAdNativeLandingPagesUI.a(this.ryv).yF)).id));
            if (fragment != null) {
                ((b) fragment).bxJ();
            }
        }
    }

    public final void ae(int i) {
        super.ae(i);
        for (int i2 = 0; i2 < this.ryv.rxB.size(); i2++) {
            Fragment fragment = (Fragment) SnsAdNativeLandingPagesUI.f(this.ryv).get(Integer.valueOf(((c) this.ryv.rxB.get(i2)).id));
            if (fragment != null) {
                if (i2 == i) {
                    ((b) fragment).bxJ();
                } else {
                    ((b) fragment).bxI();
                }
            }
        }
    }
}
