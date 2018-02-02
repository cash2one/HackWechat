package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class SingleChatInfoUI$a implements OnCancelListener {
    private SingleChatInfoUI$a() {
    }

    public final void onCancel(DialogInterface dialogInterface) {
        SingleChatInfoUI.dE(true);
    }
}
