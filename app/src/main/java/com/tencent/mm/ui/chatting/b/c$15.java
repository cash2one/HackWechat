package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;

class c$15 implements OnClickListener {
    final /* synthetic */ c yyQ;

    public c$15(c cVar) {
        this.yyQ = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yyQ.kEC.field_hadAlert = 1;
        d dVar = this.yyQ.kEC;
        if (dVar != null) {
            dVar.field_brandFlag &= -5;
            f.g(dVar);
        }
        y.Mo().ke(this.yyQ.fhr.crz());
    }
}
