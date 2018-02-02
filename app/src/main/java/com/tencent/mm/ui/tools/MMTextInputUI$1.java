package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MMTextInputUI$1 implements OnClickListener {
    final /* synthetic */ MMTextInputUI zlE;

    MMTextInputUI$1(MMTextInputUI mMTextInputUI) {
        this.zlE = mMTextInputUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zlE.aWs();
        this.zlE.setResult(0);
        this.zlE.finish();
    }
}
