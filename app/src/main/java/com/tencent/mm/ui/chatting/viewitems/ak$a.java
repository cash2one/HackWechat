package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.r$d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ak$a extends r$d {
    final /* synthetic */ ak yOk;

    public ak$a(ak akVar, a aVar) {
        this.yOk = akVar;
        super(aVar);
    }

    public final void a(View view, a aVar, au auVar) {
        ar arVar = (ar) view.getTag();
        ar.Hg();
        if (c.isSDCardAvailable()) {
            this.yqa.ysf.ysR.a(arVar.position, arVar.fEJ);
        } else {
            u.fI(this.yqa.getContext());
        }
    }
}
