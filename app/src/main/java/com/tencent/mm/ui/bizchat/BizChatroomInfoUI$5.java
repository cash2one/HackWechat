package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ag.a.n;
import com.tencent.mm.z.ar;

class BizChatroomInfoUI$5 implements OnCancelListener {
    final /* synthetic */ n yoD;
    final /* synthetic */ BizChatroomInfoUI yoK;

    BizChatroomInfoUI$5(BizChatroomInfoUI bizChatroomInfoUI, n nVar) {
        this.yoK = bizChatroomInfoUI;
        this.yoD = nVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.yoD);
    }
}
