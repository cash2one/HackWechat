package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.b.a;

class MMCreateChatroomUI$2 implements OnCancelListener {
    final /* synthetic */ MMCreateChatroomUI zof;

    MMCreateChatroomUI$2(MMCreateChatroomUI mMCreateChatroomUI) {
        this.zof = mMCreateChatroomUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        MMCreateChatroomUI.a(this.zof, false);
        if (MMCreateChatroomUI.e(this.zof) != null) {
            MMCreateChatroomUI.e(this.zof).fAK.fAJ = true;
            a.xef.m(MMCreateChatroomUI.e(this.zof));
        }
    }
}
