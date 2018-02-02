package com.tencent.mm.pluginsdk.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class c$6 implements OnClickListener {
    final /* synthetic */ OnClickListener vdj;

    c$6(OnClickListener onClickListener) {
        this.vdj = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.vdj != null) {
            this.vdj.onClick(dialogInterface, -1);
        }
    }
}
