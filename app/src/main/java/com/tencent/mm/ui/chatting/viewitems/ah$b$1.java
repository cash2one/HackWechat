package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.b.ab;
import com.tencent.mm.ui.chatting.viewitems.ah.b;

class ah$b$1 implements OnClickListener {
    final /* synthetic */ au heR;
    final /* synthetic */ a yII;
    final /* synthetic */ b yNB;

    ah$b$1(b bVar, a aVar, au auVar) {
        this.yNB = bVar;
        this.yII = aVar;
        this.heR = auVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ab abVar = this.yII.yvJ;
        ab.cuc();
        this.yII.yvJ.e(this.heR, true);
    }
}
