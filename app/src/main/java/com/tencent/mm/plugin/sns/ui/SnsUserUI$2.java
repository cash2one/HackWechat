package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class SnsUserUI$2 implements OnClickListener {
    final /* synthetic */ SnsUserUI rMb;

    SnsUserUI$2(SnsUserUI snsUserUI) {
        this.rMb = snsUserUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
