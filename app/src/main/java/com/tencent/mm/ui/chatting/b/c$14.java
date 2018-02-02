package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;

class c$14 implements OnClickListener {
    final /* synthetic */ c yyQ;
    final /* synthetic */ boolean yyV;

    public c$14(c cVar, boolean z) {
        this.yyQ = cVar;
        this.yyV = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yyQ.kEC.field_hadAlert = 1;
        d dVar = this.yyQ.kEC;
        if (dVar != null) {
            dVar.field_brandFlag |= 4;
            f.g(dVar);
        }
        if (this.yyV) {
            this.yyQ.fhr.csq().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            return;
        }
        y.Mo().ke(this.yyQ.fhr.crz());
    }
}
