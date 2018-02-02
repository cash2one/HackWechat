package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout.a;
import com.tencent.mm.z.ar;

class v$1 implements a {
    final /* synthetic */ Intent kvq;
    final /* synthetic */ int pa;
    final /* synthetic */ String yBb;
    final /* synthetic */ v yBc;

    v$1(v vVar, Intent intent, String str, int i) {
        this.yBc = vVar;
        this.kvq = intent;
        this.yBb = str;
        this.pa = i;
    }

    public final void aOk() {
        ar.Dm().g(new 1(this), 100);
    }
}
