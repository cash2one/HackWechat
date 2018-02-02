package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.s.2;

class s$2$1 implements OnClickListener {
    final /* synthetic */ Context val$context;
    final /* synthetic */ 2 ytU;

    s$2$1(2 2, Context context) {
        this.ytU = 2;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.ChattingMoreBtnBarHelper", "delete message");
        h.a(this.val$context, s.a(this.ytU.ytT).ytp, this.ytU.ytT);
        this.ytU.ytT.crR();
    }
}
