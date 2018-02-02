package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.chatting.ChattingUI.a;

class ChattingUI$a$21 implements OnClickListener {
    final /* synthetic */ a ywR;

    ChattingUI$a$21(a aVar) {
        this.ywR = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (a.q(this.ywR) != null) {
            a.q(this.ywR).dismiss();
        }
    }
}
