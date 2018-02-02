package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.a;
import com.tencent.mm.ui.base.MMPullDownView.f;
import com.tencent.mm.ui.widget.QImageView;

class SnsTimeLineUI$29 implements f {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$29(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void ax(float f) {
        SnsTimeLineUI.C(this.rIN);
        if (SnsTimeLineUI.h(this.rIN).raX.getTop() >= SnsTimeLineUI.z(this.rIN).rJf || f > 0.0f) {
            a z = SnsTimeLineUI.z(this.rIN);
            if (z.nKG != null) {
                if (z.nKG.getFirstVisiblePosition() == 0) {
                    SnsTimeLineUI.l(z.rIN).setVisibility(0);
                } else {
                    SnsTimeLineUI.l(z.rIN).setVisibility(8);
                }
            }
            if (SnsTimeLineUI.l(z.rIN).getVisibility() == 0) {
                SnsTimeLineUI.l(z.rIN).clearAnimation();
                z.init();
                z.rJc -= f / 2.0f;
                float f2 = z.rJc;
                if (f2 < z.rJb) {
                    f2 = z.rJb;
                    z.rJc = z.rJb;
                }
                float f3 = f2 > z.rJa ? z.rJa : f2;
                f2 = f3 == z.rJa ? f * 2.0f : 5.0f * f;
                SnsTimeLineUI.l(z.rIN).a(QImageView.a.zwb);
                SnsTimeLineUI.l(z.rIN).mMatrix.postRotate(f2, z.rIY, z.rIZ);
                SnsTimeLineUI.l(z.rIN).setImageResource(i.qIN);
                LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.l(z.rIN).getLayoutParams();
                layoutParams.y = (int) f3;
                SnsTimeLineUI.l(z.rIN).setLayoutParams(layoutParams);
                SnsTimeLineUI.l(z.rIN).invalidate();
            }
        }
        SnsTimeLineUI.g(this.rIN).bze();
        this.rIN.bzr();
        SnsTimeLineUI.g(this.rIN).rrx.bCm();
    }

    public final void bBR() {
        SnsTimeLineUI.z(this.rIN).bBT();
    }
}
