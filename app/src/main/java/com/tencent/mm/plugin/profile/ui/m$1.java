package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class m$1 implements OnClickListener {
    final /* synthetic */ m pjK;

    m$1(m mVar) {
        this.pjK = mVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pjK.j(this.pjK.context, false);
    }
}
