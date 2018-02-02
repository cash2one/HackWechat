package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.contact.VoipAddressUI;

class ab$1 implements OnClickListener {
    final /* synthetic */ ab xMg;

    ab$1(ab abVar) {
        this.xMg = abVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b riVar = new ri();
        riVar.fJc.fJf = true;
        a.xef.m(riVar);
        VoipAddressUI.fR(ab.c(this.xMg));
        dialogInterface.dismiss();
    }
}
