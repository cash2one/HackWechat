package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ag.a.n;
import com.tencent.mm.z.ar;

class BizChatSelectConversationUI$5 implements OnCancelListener {
    final /* synthetic */ BizChatSelectConversationUI yoC;
    final /* synthetic */ n yoD;

    BizChatSelectConversationUI$5(BizChatSelectConversationUI bizChatSelectConversationUI, n nVar) {
        this.yoC = bizChatSelectConversationUI;
        this.yoD = nVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.yoD);
    }
}
