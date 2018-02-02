package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ag.a.x;
import com.tencent.mm.z.ar;

class BizChatroomInfoUI$6 implements OnCancelListener {
    final /* synthetic */ BizChatroomInfoUI yoK;
    final /* synthetic */ x yoL;

    BizChatroomInfoUI$6(BizChatroomInfoUI bizChatroomInfoUI, x xVar) {
        this.yoK = bizChatroomInfoUI;
        this.yoL = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.yoL);
    }
}
