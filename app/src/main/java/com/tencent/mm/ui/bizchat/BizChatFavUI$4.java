package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ag.a.h;
import com.tencent.mm.ag.a.w;
import com.tencent.mm.ag.y;

class BizChatFavUI$4 implements OnCancelListener {
    final /* synthetic */ BizChatFavUI ynN;
    final /* synthetic */ w ynO;

    BizChatFavUI$4(BizChatFavUI bizChatFavUI, w wVar) {
        this.ynN = bizChatFavUI;
        this.ynO = wVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        y.Ml();
        h.f(this.ynO);
    }
}
