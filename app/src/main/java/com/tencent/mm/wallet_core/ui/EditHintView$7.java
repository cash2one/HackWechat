package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class EditHintView$7 implements OnClickListener {
    final /* synthetic */ EditHintView zIQ;

    EditHintView$7(EditHintView editHintView) {
        this.zIQ = editHintView;
    }

    public final void onClick(View view) {
        if (EditHintView.l(this.zIQ).getVisibility() != 0) {
            return;
        }
        if (this.zIQ.imW && !bh.ov(this.zIQ.getText())) {
            this.zIQ.zIF.ClearInput();
        } else if (EditHintView.f(this.zIQ) != 1) {
            EditHintView.o(this.zIQ);
        } else if (EditHintView.m(this.zIQ) != null && EditHintView.n(this.zIQ)) {
        }
    }
}
