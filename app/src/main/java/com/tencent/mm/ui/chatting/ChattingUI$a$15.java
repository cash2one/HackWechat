package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;

class ChattingUI$a$15 implements OnClickListener {
    final /* synthetic */ au heR;
    final /* synthetic */ a ywR;

    public ChattingUI$a$15(a aVar, au auVar) {
        this.ywR = aVar;
        this.heR = auVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.ywR.az(this.heR);
    }
}
