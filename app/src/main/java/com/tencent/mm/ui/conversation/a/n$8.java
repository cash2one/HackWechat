package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMAppMgr;

class n$8 implements OnClickListener {
    final /* synthetic */ int iGh;
    final /* synthetic */ n zby;

    n$8(n nVar, int i) {
        this.zby = nVar;
        this.iGh = i;
    }

    public final void onClick(View view) {
        MMAppMgr.a((Context) this.zby.voC.get(), this.iGh, new 1(this), new 2(this));
    }
}
