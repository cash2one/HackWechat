package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.ui.base.h;

class s$1 implements a {
    final /* synthetic */ s voA;

    s$1(s sVar) {
        this.voA = sVar;
    }

    public final boolean uF() {
        s sVar = this.voA;
        Context context = this.voA.context;
        this.voA.context.getString(R.l.dGO);
        sVar.mIl = h.a(context, this.voA.context.getString(R.l.dHc), true, new 1(this));
        return false;
    }
}
