package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class b$5 implements OnClickListener {
    final /* synthetic */ b ymM;

    b$5(b bVar) {
        this.ymM = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        k alVar = new al(5, this.ymM.xPo, this.ymM.xKa.xPq, this.ymM.xKa.coF(), this.ymM.xKa.xPr, true, 1);
        this.ymM.EI();
        ar.CG().a(alVar, 0);
        b bVar = this.ymM;
        Context context = this.ymM.context;
        this.ymM.context.getString(R.l.dGO);
        bVar.xPh = h.a(context, this.ymM.context.getString(R.l.etF), true, new 1(this, alVar));
    }
}
