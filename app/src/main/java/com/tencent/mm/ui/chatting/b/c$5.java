package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ag.a.h;
import com.tencent.mm.ag.y;
import com.tencent.mm.protocal.c.hl;
import com.tencent.mm.protocal.c.hm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.c.7;
import java.util.LinkedList;

class c$5 implements OnClickListener {
    final /* synthetic */ c yyQ;
    final /* synthetic */ LinkedList yyR;

    c$5(c cVar, LinkedList linkedList) {
        this.yyQ = cVar;
        this.yyR = linkedList;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        hm hmVar = new hm();
        for (int i2 = 0; i2 < this.yyR.size(); i2++) {
            hl hlVar = new hl();
            hlVar.vNr = (String) this.yyR.get(i2);
            hmVar.vNs.add(hlVar);
        }
        c cVar = this.yyQ;
        x.i("MicroMsg.ChattingUI.BizMgr", "updateBizChatMemberList()");
        String mMString = cVar.fhr.csq().getMMString(R.l.eEY);
        y.Ml();
        com.tencent.mm.ag.a.x a = h.a(cVar.ync.field_brandUserName, cVar.ync.field_bizChatServId, null, hmVar, cVar);
        Context context = cVar.fhr.csq().getContext();
        cVar.fhr.csq().getMMString(R.l.dGO);
        cVar.fhr.b(com.tencent.mm.ui.base.h.a(context, mMString, true, new 7(cVar, a)));
    }
}
