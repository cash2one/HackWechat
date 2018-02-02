package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class EditHintView$8 implements OnClickListener {
    final /* synthetic */ EditHintView zIQ;

    EditHintView$8(EditHintView editHintView) {
        this.zIQ = editHintView;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        EditHintView.p(this.zIQ).dismiss();
    }
}
