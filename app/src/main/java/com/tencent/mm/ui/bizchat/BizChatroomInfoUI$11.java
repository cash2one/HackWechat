package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class BizChatroomInfoUI$11 implements OnCancelListener {
    final /* synthetic */ BizChatroomInfoUI yoK;

    BizChatroomInfoUI$11(BizChatroomInfoUI bizChatroomInfoUI) {
        this.yoK = bizChatroomInfoUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        BizChatroomInfoUI.e(this.yoK);
    }
}
