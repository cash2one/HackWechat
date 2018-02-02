package com.tencent.mm.pluginsdk.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class c$2 implements OnClickListener {
    final /* synthetic */ OnClickListener vdi;

    c$2(OnClickListener onClickListener) {
        this.vdi = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.vdi != null) {
            this.vdi.onClick(dialogInterface, -1);
        }
    }
}
