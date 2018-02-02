package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.b.ab;

class ah$a$1 implements OnClickListener {
    final /* synthetic */ au heR;
    final /* synthetic */ a yII;
    final /* synthetic */ ah.a yNA;

    ah$a$1(ah.a aVar, au auVar, a aVar2) {
        this.yNA = aVar;
        this.heR = auVar;
        this.yII = aVar2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        q.E(this.heR);
        ab abVar = this.yII.yvJ;
        ab.cuc();
        this.yII.yvJ.e(this.heR, true);
    }
}
