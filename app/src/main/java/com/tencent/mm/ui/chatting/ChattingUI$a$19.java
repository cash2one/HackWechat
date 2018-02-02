package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.chatting.ChattingUI.a;

class ChattingUI$a$19 implements OnClickListener {
    final /* synthetic */ a ywR;

    ChattingUI$a$19(a aVar) {
        this.ywR = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }
}
