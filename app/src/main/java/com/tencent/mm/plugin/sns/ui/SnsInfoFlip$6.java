package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.ui.base.MultiTouchImageView.a;

class SnsInfoFlip$6 implements a {
    final /* synthetic */ SnsInfoFlip rCB;

    SnsInfoFlip$6(SnsInfoFlip snsInfoFlip) {
        this.rCB = snsInfoFlip;
    }

    public final void bBe() {
        if (SnsInfoFlip.g(this.rCB).getSelectedItem() != null && SnsInfoFlip.d(this.rCB) != null) {
            int selectedItemPosition = SnsInfoFlip.g(this.rCB).getSelectedItemPosition();
            m Lm = ae.bvv().Lm(((b) SnsInfoFlip.g(this.rCB).getSelectedItem()).raG);
            if (Lm != null) {
                ax.d(Lm, selectedItemPosition);
            }
        }
    }

    public final void bBf() {
        if (SnsInfoFlip.g(this.rCB).getSelectedItem() != null && SnsInfoFlip.d(this.rCB) != null) {
            int selectedItemPosition = SnsInfoFlip.g(this.rCB).getSelectedItemPosition();
            m Lm = ae.bvv().Lm(((b) SnsInfoFlip.g(this.rCB).getSelectedItem()).raG);
            if (Lm != null) {
                ax.e(Lm, selectedItemPosition);
            }
        }
    }
}
