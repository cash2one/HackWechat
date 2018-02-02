package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.ui.base.h;

class r$1 implements a {
    final /* synthetic */ r pZA;

    r$1(r rVar) {
        this.pZA = rVar;
    }

    public final boolean uF() {
        r rVar = this.pZA;
        Context context = this.pZA.context;
        this.pZA.context.getString(R.l.dGO);
        rVar.mIl = h.a(context, this.pZA.context.getString(R.l.dHc), true, new 1(this));
        return false;
    }
}
