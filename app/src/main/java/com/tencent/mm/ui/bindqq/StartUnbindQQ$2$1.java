package com.tencent.mm.ui.bindqq;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.af.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bindqq.StartUnbindQQ.2;
import com.tencent.mm.z.ar;

class StartUnbindQQ$2$1 implements OnClickListener {
    final /* synthetic */ 2 ymQ;

    StartUnbindQQ$2$1(2 2) {
        this.ymQ = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ar.CG().a(new b(""), 0);
        StartUnbindQQ startUnbindQQ = this.ymQ.ymP;
        Context context = this.ymQ.ymP;
        this.ymQ.ymP.getString(R.l.dGO);
        StartUnbindQQ.a(startUnbindQQ, h.a(context, this.ymQ.ymP.getString(R.l.eKD), true, null));
    }
}
