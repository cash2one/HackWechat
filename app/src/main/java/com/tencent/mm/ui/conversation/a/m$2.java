package com.tencent.mm.ui.conversation.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class m$2 implements OnCancelListener {
    m$2() {
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }
}
