package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$7 implements OnCancelListener {
    final /* synthetic */ a ynJ;

    BizChatConversationUI$a$7(a aVar) {
        this.ynJ = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a.m(this.ynJ);
    }
}
