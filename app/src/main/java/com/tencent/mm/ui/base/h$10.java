package com.tencent.mm.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

class h$10 implements OnCancelListener {
    final /* synthetic */ OnClickListener tvO;

    h$10(OnClickListener onClickListener) {
        this.tvO = onClickListener;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.tvO != null) {
            this.tvO.onClick(dialogInterface, 0);
        }
    }
}
