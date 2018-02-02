package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.ui.base.PasterEditText;
import com.tencent.mm.ui.base.i;

class e$5 implements OnClickListener {
    final /* synthetic */ i vnn;
    final /* synthetic */ a vno;

    e$5(i iVar, a aVar) {
        this.vnn = iVar;
        this.vno = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.vnn.dismiss();
        if (this.vno != null) {
            a aVar = this.vno;
            String coS = this.vnn.coS();
            i iVar = this.vnn;
            aVar.a(true, coS, iVar.kT instanceof PasterEditText ? ((PasterEditText) iVar.kT).bAS() : 0);
        }
    }
}
