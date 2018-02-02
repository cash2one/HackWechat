package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class b$1 implements OnClickListener {
    final /* synthetic */ Context rkw;
    final /* synthetic */ b xNq;

    b$1(b bVar, Context context) {
        this.xNq = bVar;
        this.rkw = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        k a = this.xNq.a(this.xNq.xNp, this.xNq.xKa.coF());
        ar.CG().a(a, 0);
        Context context = this.rkw;
        this.rkw.getString(R.l.dGO);
        h.a(context, this.rkw.getString(R.l.etF), true, new 1(this, a));
    }
}
