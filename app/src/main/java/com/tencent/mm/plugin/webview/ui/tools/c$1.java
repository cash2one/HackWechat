package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class c$1 implements a {
    final /* synthetic */ c twG;

    c$1(c cVar) {
        this.twG = cVar;
    }

    public final boolean uF() {
        if (this.twG.twF.isFinishing()) {
            x.w("MicroMsg.OAuthSession", "onTimerExpired, context is finishing");
        } else {
            c cVar = this.twG;
            Context context = this.twG.twF;
            this.twG.twF.getString(R.l.dGO);
            cVar.mIl = h.a(context, this.twG.twF.getString(R.l.dHc), true, new 1(this));
        }
        return false;
    }
}
